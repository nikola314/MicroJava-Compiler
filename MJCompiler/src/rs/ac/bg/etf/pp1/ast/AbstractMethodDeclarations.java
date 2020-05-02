// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:13:49


package rs.ac.bg.etf.pp1.ast;

public class AbstractMethodDeclarations extends AbstractMethodDeclarationList {

    private AbstractMethodDeclarationList AbstractMethodDeclarationList;
    private AnyMethodDecl AnyMethodDecl;

    public AbstractMethodDeclarations (AbstractMethodDeclarationList AbstractMethodDeclarationList, AnyMethodDecl AnyMethodDecl) {
        this.AbstractMethodDeclarationList=AbstractMethodDeclarationList;
        if(AbstractMethodDeclarationList!=null) AbstractMethodDeclarationList.setParent(this);
        this.AnyMethodDecl=AnyMethodDecl;
        if(AnyMethodDecl!=null) AnyMethodDecl.setParent(this);
    }

    public AbstractMethodDeclarationList getAbstractMethodDeclarationList() {
        return AbstractMethodDeclarationList;
    }

    public void setAbstractMethodDeclarationList(AbstractMethodDeclarationList AbstractMethodDeclarationList) {
        this.AbstractMethodDeclarationList=AbstractMethodDeclarationList;
    }

    public AnyMethodDecl getAnyMethodDecl() {
        return AnyMethodDecl;
    }

    public void setAnyMethodDecl(AnyMethodDecl AnyMethodDecl) {
        this.AnyMethodDecl=AnyMethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AbstractMethodDeclarationList!=null) AbstractMethodDeclarationList.accept(visitor);
        if(AnyMethodDecl!=null) AnyMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AbstractMethodDeclarationList!=null) AbstractMethodDeclarationList.traverseTopDown(visitor);
        if(AnyMethodDecl!=null) AnyMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AbstractMethodDeclarationList!=null) AbstractMethodDeclarationList.traverseBottomUp(visitor);
        if(AnyMethodDecl!=null) AnyMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractMethodDeclarations(\n");

        if(AbstractMethodDeclarationList!=null)
            buffer.append(AbstractMethodDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AnyMethodDecl!=null)
            buffer.append(AnyMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractMethodDeclarations]");
        return buffer.toString();
    }
}
