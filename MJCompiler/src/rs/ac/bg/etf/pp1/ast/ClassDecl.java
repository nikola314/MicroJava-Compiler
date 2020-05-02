// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:13:49


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private IfExtends IfExtends;
    private VarDeclarationList VarDeclarationList;
    private IfMethodDeclarations IfMethodDeclarations;

    public ClassDecl (String I1, IfExtends IfExtends, VarDeclarationList VarDeclarationList, IfMethodDeclarations IfMethodDeclarations) {
        this.I1=I1;
        this.IfExtends=IfExtends;
        if(IfExtends!=null) IfExtends.setParent(this);
        this.VarDeclarationList=VarDeclarationList;
        if(VarDeclarationList!=null) VarDeclarationList.setParent(this);
        this.IfMethodDeclarations=IfMethodDeclarations;
        if(IfMethodDeclarations!=null) IfMethodDeclarations.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public IfExtends getIfExtends() {
        return IfExtends;
    }

    public void setIfExtends(IfExtends IfExtends) {
        this.IfExtends=IfExtends;
    }

    public VarDeclarationList getVarDeclarationList() {
        return VarDeclarationList;
    }

    public void setVarDeclarationList(VarDeclarationList VarDeclarationList) {
        this.VarDeclarationList=VarDeclarationList;
    }

    public IfMethodDeclarations getIfMethodDeclarations() {
        return IfMethodDeclarations;
    }

    public void setIfMethodDeclarations(IfMethodDeclarations IfMethodDeclarations) {
        this.IfMethodDeclarations=IfMethodDeclarations;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfExtends!=null) IfExtends.accept(visitor);
        if(VarDeclarationList!=null) VarDeclarationList.accept(visitor);
        if(IfMethodDeclarations!=null) IfMethodDeclarations.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfExtends!=null) IfExtends.traverseTopDown(visitor);
        if(VarDeclarationList!=null) VarDeclarationList.traverseTopDown(visitor);
        if(IfMethodDeclarations!=null) IfMethodDeclarations.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfExtends!=null) IfExtends.traverseBottomUp(visitor);
        if(VarDeclarationList!=null) VarDeclarationList.traverseBottomUp(visitor);
        if(IfMethodDeclarations!=null) IfMethodDeclarations.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(IfExtends!=null)
            buffer.append(IfExtends.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclarationList!=null)
            buffer.append(VarDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IfMethodDeclarations!=null)
            buffer.append(IfMethodDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl]");
        return buffer.toString();
    }
}
