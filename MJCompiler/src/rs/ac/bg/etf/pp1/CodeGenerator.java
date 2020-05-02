package rs.ac.bg.etf.pp1;


import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.CounterVisitor.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	private int mainPc;
	
	public int getMainPc() {
		return mainPc;
	}
	
	private void visitMethod(MethodTypeAndName Method) {
		Method.obj.setAdr(Code.pc);
		Code.put(Code.enter);
		
		FormParamCounter paramCounter = new FormParamCounter();
		Method.getParent().traverseTopDown(paramCounter);		
		Code.put(paramCounter.getCount());
		
		Code.put(Method.obj.getLocalSymbols().size());
	}
	
	@Override
	public void visit(MethodTypeVoid MethodTypeVoid) {
		if(MethodTypeVoid.getMethodName().equals("main")) {
			mainPc = Code.pc;
		}
		visitMethod(MethodTypeVoid);
	}
	
	@Override
	public void visit(MethodTypeCustom MethodTypeCustom) {
		visitMethod(MethodTypeCustom);
	}
	
	@Override
	public void visit(MethodDecl MethodDecl) {
//		if(MethodDecl.getMethodTypeAndName().obj.getType() == Tab.noType) {
			Code.put(Code.exit);
			Code.put(Code.return_);
//		}
//		else {
//			Code.put(Code.trap);
//			Code.put(1);
//		}
	}
	
	@Override
	public void visit(StatementRead StatementRead) {
		Designator designator = StatementRead.getDesignator();
		if(designator.obj.getType() == Tab.charType) {
			Code.put(Code.bread);
		}
		else {
			Code.put(Code.read);
		}
		Code.store(designator.obj);
	}
	
	@Override
	public void visit(StatementPrint StatementPrint) {
		IfNumConst hasWidth = StatementPrint.getIfNumConst();
		int width=1;
		if(hasWidth instanceof NumConstExists) {
			width = ((NumConstExists) hasWidth).getValue();
		}
		Code.loadConst(width);
		if(StatementPrint.getExpr().struct.getKind() == Struct.Char) {
			Code.put(Code.bprint);
		}
		else {
			Code.put(Code.print);
		}
	}
	
	@Override
	public void visit(FactorNum FactorNum) {
		Code.loadConst(FactorNum.getValue());
	}
	
	@Override
	public void visit(FactorChar FactorChar) {
		Code.loadConst(FactorChar.getValue());
	}

	@Override
	public void visit(FactorBool FactorBool) {
		Code.loadConst(
				FactorBool.getValue()? 1:0
				);
	}
	
	@Override
	public void visit(FactorOther FactorOther) {
		if(FactorOther.getIfNewArray() instanceof NotArray) return;
		Code.put(Code.newarray);
		if(FactorOther.getType().struct.equals(Tab.charType)){
			Code.put(0);
		}
		else {
			Code.put(1);
		}
	}
	
	@Override
	public void visit(FactorDesig FactorDesig) {
		IfActParsExist pars = FactorDesig.getIfActParsExist();
		if(pars instanceof ParsExist) {
			int offset = FactorDesig.getDesignator().obj.getAdr() - Code.pc;
			Code.put(Code.call);
			Code.put2(offset);
		}
		else {
			Code.load(FactorDesig.getDesignator().obj);
		}		
	}
	
	@Override
	public void visit(DesignatorExprLR DesignatorExprLR) {
		Code.load(DesignatorExprLR.getDesignator().obj);
	}
	
	private void DesiOptionIncOrDec(DesignatorStatement ds, int opcode) {
		Designator d = ds.getDesignator();	
		if(d.obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		Code.load(d.obj);
		Code.loadConst(1);
		Code.put(opcode);
		Code.store(d.obj);
	}
	
	@Override
	public void visit(DesiOptActPars DesiOptActPars) {
		DesignatorStatement d = (DesignatorStatement)DesiOptActPars.getParent();
		Obj obj = d.getDesignator().obj;
		int offset = obj.getAdr()-Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
		if(obj.getType() != Tab.noType) {
			Code.put(Code.pop);
		}
	}
	
	
	@Override
	public void visit(DesiOptInc DesiOptInc) {
		DesignatorStatement ds = (DesignatorStatement) DesiOptInc.getParent();		
		DesiOptionIncOrDec(ds,Code.add);
	}
	
	@Override
	public void visit(DesiOptDec DesiOptDec) {
		DesignatorStatement ds = (DesignatorStatement) DesiOptDec.getParent();		
		DesiOptionIncOrDec(ds,Code.sub);
	}
	
	@Override
	public void visit(DesiOptAssign DesiOptAssign) {
		DesignatorStatement ds = (DesignatorStatement)DesiOptAssign.getParent();
		Code.store(ds.getDesignator().obj);
	}
	
	@Override
	public void visit(TermMulopFactor TermMulopFactor) {
		Mulop mulop = TermMulopFactor.getMulop();
		if(mulop instanceof MulopDiv) {
			Code.put(Code.div);
		}
		else if(mulop instanceof MulopMul) {
			Code.put(Code.mul);
		}
		else {
			Code.put(Code.rem);
		}
	}
	
	@Override
	public void visit(ExprAddopTerm ExprAddopTerm) {
		Addop addop = ExprAddopTerm.getAddop();
		if(addop instanceof AddopPlus) {
			Code.put(Code.add);
		}
		else {
			Code.put(Code.sub);
		}
	}
	
	@Override
	public void visit(ExprMinusTerm ExprMinusTerm) {
		Code.put(Code.neg);
	}
}

