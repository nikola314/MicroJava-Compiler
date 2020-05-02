package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;

public class SemanticAnalyzer extends VisitorAdaptor {

	boolean errorDetected = false;
	boolean returnFound = false;
	Obj currentMethod =null;
	int nVars;
	Struct lastType = null;
	boolean mainExists = false;
	static final Struct boolType = new Struct(Struct.Bool);
	int cntConsts = 0;
	int cntGlobals = 0;
	int cntArrayAcces = 0;
	
	Logger log = Logger.getLogger(getClass());
	
	public boolean passed() {
		return !errorDetected;
	}
		
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" on line ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" on line ").append(line);
		log.info(msg.toString());
	}
	
	@Override
	public void visit(ProgramName ProgramName) {
		ProgramName.obj = Tab.insert(Obj.Prog, ProgramName.getProgramName(), Tab.noType);
		Tab.openScope(); 
	}

	@Override
	public void visit(Program Program) {
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(Program.getProgramName().obj);
		Tab.closeScope();
		checkForMain();
	}
	
	private void checkForMain() {
		if(!mainExists) {
			report_error("Error: main does not exist", null);
		}
	}
	
	@Override
	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getI1());
		if(typeNode == Tab.noObj) {
			type.struct = Tab.noType;
			report_error("Type "+type.getI1()+" not found in symbol table",null);
		}
		else {
			if(typeNode.getKind() != Obj.Type) {
				type.struct = Tab.noType;
				report_error(type.getI1()+" is not a type",null);
			}
			else {
				type.struct = typeNode.getType();
			}
		}
		lastType = type.struct;
	}

	@Override
	public void visit(ConstBool ConstBool) {
		if(lastType == null || lastType.getKind() != Struct.Bool) {
			report_error("Error: incompatible types",ConstBool);
		}
		Obj entry = Tab.currentScope.findSymbol(ConstBool.getVarName());
		if(entry == null) {
			entry = Tab.insert(Obj.Con, ConstBool.getVarName(), lastType);
			int value = ConstBool.getVarValue()==true? 1:0;
			entry.setAdr(value);
		}
		else {
			report_error("Error: symbol "+ConstBool.getVarName()+" already declared", ConstBool);
		}
	}

	@Override
	public void visit(ConstInt ConstInt) {
		if(!lastType.equals(Tab.intType)) {
			report_error("Error: incompatible types",ConstInt);
		}
		Obj entry = Tab.currentScope.findSymbol(ConstInt.getVarName());
		if(entry == null) {
			entry = Tab.insert(Obj.Con, ConstInt.getVarName(), lastType);
			entry.setAdr(ConstInt.getVarValue());
		}
		else {
			report_error("Error: symbol "+ConstInt.getVarName()+" already declared", ConstInt);
		}
	}

	@Override
	public void visit(ConstChar ConstChar) {
		if(!lastType.equals(Tab.charType)) {
			report_error("Error: incompatible types",ConstChar);
		}
		Obj entry = Tab.currentScope.findSymbol(ConstChar.getVarName());
		if(entry == null) {
			entry = Tab.insert(Obj.Con, ConstChar.getVarName(), lastType);
			entry.setAdr(ConstChar.getVarValue());
		}
		else {
			report_error("Error: symbol "+ConstChar.getVarName()+" already declared", ConstChar);
		}
	}
	
	@Override
	public void visit(VarIdentifier VarIdentifier) {
		Obj entry = Tab.currentScope.findSymbol(VarIdentifier.getVarName());
		if(entry == null) {
			if(VarIdentifier.getBracketsIfArray() instanceof WithoutBrackets) {
				entry = Tab.insert(Obj.Var, VarIdentifier.getVarName(), lastType);
			}
			else {
				entry = Tab.insert(Obj.Var, VarIdentifier.getVarName(), new Struct(Struct.Array,lastType));
			}
		}
		else {
			report_error("Error: symbol "+VarIdentifier.getVarName()+" already declared",VarIdentifier);
		}
	}
	
	@Override
	public void visit(MethodDecl MethodDecl) {
		checkIfMain(MethodDecl);
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		currentMethod = null;
	}
	
	private void checkIfMain(MethodDecl MethodDecl) {
		if(		MethodDecl.getMethodTypeAndName().obj.getName().equals("main")
				&& MethodDecl.getFormPars() instanceof NoFormalParameters
				&& MethodDecl.getMethodTypeAndName() instanceof MethodTypeVoid) {
			mainExists = true;
		}
	}
	
	@Override
	public void visit(MethodTypeCustom MethodTypeCustom) {
		MethodTypeCustom.obj = currentMethod = Tab.insert(Obj.Meth, MethodTypeCustom.getMethodName(), MethodTypeCustom.getType().struct);		
		Tab.openScope();
	}
	
	@Override 
	public void visit(MethodTypeVoid MethodTypeVoid) {
		MethodTypeVoid.obj = currentMethod = Tab.insert(Obj.Meth, MethodTypeVoid.getMethodName(), Tab.noType);		
		Tab.openScope();
	}
	
	@Override
	public void visit(FactorExpr FactorExpr) {
		FactorExpr.struct = FactorExpr.getExpr().struct;
	}
	
	@Override
	public void visit(FactorNum FactorNum) {
		FactorNum.struct = Tab.intType;
	}
	
	@Override
	public void visit(FactorChar FactorChar) {
		FactorChar.struct = Tab.charType;
	}
	
	@Override
	public void visit(FactorBool FactorBool) {
		FactorBool.struct = boolType;
	}
	
	@Override
	public void visit(FactorOther FactorOther) {
		Struct retType = lastType;
		if(FactorOther.getIfNewArray() instanceof IsArray) {		
			IsArray arrayExpr = (IsArray)FactorOther.getIfNewArray();
			Struct type = arrayExpr.getExpr().struct;
			if(!type.compatibleWith(Tab.intType)) {
				report_error("Error: expression must be int",FactorOther);
			}
			retType = new Struct(Struct.Array, lastType);
		}
		FactorOther.struct = retType;
	}
	
	@Override
	public void visit(FactorDesig FactorDesig) {
		int desigKind = FactorDesig.getDesignator().obj.getKind();
		if(	desigKind != Obj.Meth &&
			FactorDesig.getIfActParsExist() instanceof ParsExist) {
			report_error("Error: method type expected",FactorDesig);
		}
		if( desigKind == Obj.Meth || 
			desigKind == Obj.Var ||
			desigKind == Obj.Con ||
			desigKind == Obj.Fld ||
			desigKind == Obj.Elem ) {
			FactorDesig.struct = FactorDesig.getDesignator().obj.getType();
		}
	}
	
	@Override
	public void visit(DesignatorLR DesignatorLR) {
		Obj desigObj = DesignatorLR.getDesignator().obj;
		Obj desigLRObj = desigObj.getType().getMembersTable().searchKey(DesignatorLR.getI2());		
		if(desigLRObj == null) {
			report_error("Error: member "+ DesignatorLR.getI2()+" does not exist", DesignatorLR);
		}
		DesignatorLR.obj = desigLRObj;
	}
	
	@Override
	public void visit(DesignatorExpr DesignatorExpr) {
		if(DesignatorExpr.getDesignatorExprLR().getDesignator().obj.getType().getKind() != Struct.Array) {
			report_error("Error: type is not an array",DesignatorExpr);
		}
		if(!DesignatorExpr.getExpr().struct.compatibleWith(Tab.intType)) {
			report_error("Error: expression must be int", DesignatorExpr);
		}
		Struct type = DesignatorExpr.getDesignatorExprLR().getDesignator().obj.getType().getElemType();
		DesignatorExpr.obj = new Obj(Obj.Elem, "", type);
	}
	
	@Override
	public void visit(DesignatorIdent DesignatorIdent) {
		Obj entry = Tab.find(DesignatorIdent.getVarName());
		if(entry == Tab.noObj) {
			report_error("Error: symbol not declared", DesignatorIdent);
		}
		DesignatorIdent.obj = entry;
		DumpSymbolTableVisitor visitor = new DumpSymbolTableVisitor();
		visitor.visitObjNode(entry);

		String msg=null;
		if (entry.getType().getKind() == Struct.Array) {
			report_info("Array "+getSymbolInfo(DesignatorIdent.obj),DesignatorIdent);
		}
		switch(entry.getKind()) {
		case Obj.Var: 
			if(entry.getLevel() == 0) {
				msg = "Global "+getSymbolInfo(DesignatorIdent.obj);
			}
			break;
		case Obj.Con: 
			msg = "Constant "+getSymbolInfo(DesignatorIdent.obj);
			break;
		}
		if(msg!=null) {
			report_info(msg,DesignatorIdent);
		}
	}
	
	private String getSymbolInfo(Obj sym) {
		return "symbol -> name:"+ sym.getName() +" | adr:"+ sym.getAdr()+" | kind:"+sym.getKind()+" | level:"+sym.getLevel() +" | frppos:"+sym.getFpPos();		
	}

	@Override
	public void visit(DesignatorStatement DesignatorStatement) {
		DesignatorStatementOptions opt = DesignatorStatement.getDesignatorStatementOptions();
		if(opt instanceof DesiOptAssign) {
			DesiOptAssign doa = (DesiOptAssign)opt;
			checkIfDesignatorValid(DesignatorStatement.getDesignator().obj.getKind(), doa);
			checkIfAssignable(doa.getExpr().struct, DesignatorStatement.getDesignator().obj.getType(), doa);
		}
		else if(opt instanceof DesiOptActPars) {
			if(DesignatorStatement.getDesignator().obj.getKind() != Obj.Meth) {
				report_error("Error: method expected", opt);
			}			
		}
		else if(opt instanceof DesiOptInc) {
			DesiOptInc doa = (DesiOptInc)opt;
			checkIfDesignatorValid(DesignatorStatement.getDesignator().obj.getKind(), doa);
			checkIfTypeInt(DesignatorStatement.getDesignator().obj.getType(), doa);
		}
		else if(opt instanceof DesiOptDec) {
			DesiOptDec doa = (DesiOptDec)opt;
			checkIfDesignatorValid(DesignatorStatement.getDesignator().obj.getKind(), doa);
			checkIfTypeInt(DesignatorStatement.getDesignator().obj.getType(), doa);
		}
			
	}
	
	private void checkIfDesignatorValid(int kind, SyntaxNode d) {
		if(kind != Obj.Fld && kind!= Obj.Var && kind != Obj.Elem) {
			report_error("Error: variable expected",d);
		}
	}
	
	private void checkIfAssignable(Struct a, Struct b,DesignatorStatementOptions d) {
		if(!a.assignableTo(b)) {
			report_error("Error: impossible assignment - "+a.getKind()+", and "+b.getKind(), d);
		}
	}
	
	private void checkIfTypeInt(Struct s, DesignatorStatementOptions d) {
		if(!s.equals(Tab.intType)) {
			report_error("Error: type mismatch, int expected", d);
		}
	}
	
	private void checkIfBasicType(Struct s, SyntaxNode n) {
		if(		!s.equals(Tab.charType) &&
				!s.equals(Tab.intType) &&
				!s.equals(this.boolType)) {
			report_error("Error: type mismatch, char, int or bool expected", n);
		}
	}
	
	private void checkIfCompatibleWithBasicTypes(Struct type, SyntaxNode s) {
		if(!type.compatibleWith(Tab.charType) && !type.compatibleWith(Tab.intType) && !type.compatibleWith(this.boolType)) {
			report_error("Error: incompatible type", s);
		}
	}
	
	@Override
	public void visit(StatementRead StatementRead) {
		checkIfDesignatorValid(StatementRead.getDesignator().obj.getKind(),StatementRead);
		checkIfBasicType(StatementRead.getDesignator().obj.getType(), StatementRead);
	}
	
	@Override
	public void visit(StatementPrint StatementPrint) {
		checkIfCompatibleWithBasicTypes(StatementPrint.getExpr().struct,StatementPrint);
	}
	
	@Override
	public void visit(ExprMinusTerm ExprMinusTerm) {
		if(!ExprMinusTerm.getTerm().struct.compatibleWith(Tab.intType)) {
			report_error("Error: operator - must stand with int type", ExprMinusTerm);
		}
		ExprMinusTerm.struct = ExprMinusTerm.getTerm().struct;
	}
	
	@Override
	public void visit(ExprTerm ExprTerm) {
		ExprTerm.struct = ExprTerm.getTerm().struct;
	}
	
	@Override
	public void visit(ExprAddopTerm ExprAddopTerm) {
		if(!ExprAddopTerm.getExpr().struct.compatibleWith(ExprAddopTerm.getTerm().struct ) &&
				!ExprAddopTerm.getExpr().struct.compatibleWith(Tab.intType)){
			report_error("Error: type mismatch", ExprAddopTerm);
		}		
		ExprAddopTerm.struct = ExprAddopTerm.getTerm().struct;
	}
	
	@Override
	public void visit(TermMulopFactor TermMulopFactor) {
		if(!TermMulopFactor.getFactor().struct.compatibleWith(TermMulopFactor.getTerm().struct) &&
				!TermMulopFactor.getFactor().struct.compatibleWith(Tab.intType)){
			report_error("Error: type mismatch", TermMulopFactor);
		}	
		TermMulopFactor.struct = TermMulopFactor.getFactor().struct;
	}
	
	@Override
	public void visit(TermFactor TermFactor) {
		TermFactor.struct = TermFactor.getFactor().struct;
	}
	
}
