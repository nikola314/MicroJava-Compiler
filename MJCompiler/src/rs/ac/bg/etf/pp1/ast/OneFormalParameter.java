// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:13:49


package rs.ac.bg.etf.pp1.ast;

public class OneFormalParameter extends FormParameterList {

    private FormalParameterDeclaration FormalParameterDeclaration;

    public OneFormalParameter (FormalParameterDeclaration FormalParameterDeclaration) {
        this.FormalParameterDeclaration=FormalParameterDeclaration;
        if(FormalParameterDeclaration!=null) FormalParameterDeclaration.setParent(this);
    }

    public FormalParameterDeclaration getFormalParameterDeclaration() {
        return FormalParameterDeclaration;
    }

    public void setFormalParameterDeclaration(FormalParameterDeclaration FormalParameterDeclaration) {
        this.FormalParameterDeclaration=FormalParameterDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormalParameterDeclaration!=null) FormalParameterDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormalParameterDeclaration!=null) FormalParameterDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormalParameterDeclaration!=null) FormalParameterDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OneFormalParameter(\n");

        if(FormalParameterDeclaration!=null)
            buffer.append(FormalParameterDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OneFormalParameter]");
        return buffer.toString();
    }
}
