// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:13:50


package rs.ac.bg.etf.pp1.ast;

public class IfAMethodDecls extends IfAbstractMethodDeclarations {

    private AbstractMethodDeclarationList AbstractMethodDeclarationList;

    public IfAMethodDecls (AbstractMethodDeclarationList AbstractMethodDeclarationList) {
        this.AbstractMethodDeclarationList=AbstractMethodDeclarationList;
        if(AbstractMethodDeclarationList!=null) AbstractMethodDeclarationList.setParent(this);
    }

    public AbstractMethodDeclarationList getAbstractMethodDeclarationList() {
        return AbstractMethodDeclarationList;
    }

    public void setAbstractMethodDeclarationList(AbstractMethodDeclarationList AbstractMethodDeclarationList) {
        this.AbstractMethodDeclarationList=AbstractMethodDeclarationList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AbstractMethodDeclarationList!=null) AbstractMethodDeclarationList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AbstractMethodDeclarationList!=null) AbstractMethodDeclarationList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AbstractMethodDeclarationList!=null) AbstractMethodDeclarationList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfAMethodDecls(\n");

        if(AbstractMethodDeclarationList!=null)
            buffer.append(AbstractMethodDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfAMethodDecls]");
        return buffer.toString();
    }
}
