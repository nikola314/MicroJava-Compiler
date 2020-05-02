// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:13:49


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private IfExtends IfExtends;
    private VarDeclarationList VarDeclarationList;
    private IfAbstractMethodDeclarations IfAbstractMethodDeclarations;

    public AbstractClassDecl (String I1, IfExtends IfExtends, VarDeclarationList VarDeclarationList, IfAbstractMethodDeclarations IfAbstractMethodDeclarations) {
        this.I1=I1;
        this.IfExtends=IfExtends;
        if(IfExtends!=null) IfExtends.setParent(this);
        this.VarDeclarationList=VarDeclarationList;
        if(VarDeclarationList!=null) VarDeclarationList.setParent(this);
        this.IfAbstractMethodDeclarations=IfAbstractMethodDeclarations;
        if(IfAbstractMethodDeclarations!=null) IfAbstractMethodDeclarations.setParent(this);
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

    public IfAbstractMethodDeclarations getIfAbstractMethodDeclarations() {
        return IfAbstractMethodDeclarations;
    }

    public void setIfAbstractMethodDeclarations(IfAbstractMethodDeclarations IfAbstractMethodDeclarations) {
        this.IfAbstractMethodDeclarations=IfAbstractMethodDeclarations;
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
        if(IfAbstractMethodDeclarations!=null) IfAbstractMethodDeclarations.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfExtends!=null) IfExtends.traverseTopDown(visitor);
        if(VarDeclarationList!=null) VarDeclarationList.traverseTopDown(visitor);
        if(IfAbstractMethodDeclarations!=null) IfAbstractMethodDeclarations.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfExtends!=null) IfExtends.traverseBottomUp(visitor);
        if(VarDeclarationList!=null) VarDeclarationList.traverseBottomUp(visitor);
        if(IfAbstractMethodDeclarations!=null) IfAbstractMethodDeclarations.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassDecl(\n");

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

        if(IfAbstractMethodDeclarations!=null)
            buffer.append(IfAbstractMethodDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassDecl]");
        return buffer.toString();
    }
}
