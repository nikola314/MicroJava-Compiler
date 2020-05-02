// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:13:49


package rs.ac.bg.etf.pp1.ast;

public class FormalParameters extends FormParameterList {

    private FormParameterList FormParameterList;
    private FormalParameterDeclaration FormalParameterDeclaration;

    public FormalParameters (FormParameterList FormParameterList, FormalParameterDeclaration FormalParameterDeclaration) {
        this.FormParameterList=FormParameterList;
        if(FormParameterList!=null) FormParameterList.setParent(this);
        this.FormalParameterDeclaration=FormalParameterDeclaration;
        if(FormalParameterDeclaration!=null) FormalParameterDeclaration.setParent(this);
    }

    public FormParameterList getFormParameterList() {
        return FormParameterList;
    }

    public void setFormParameterList(FormParameterList FormParameterList) {
        this.FormParameterList=FormParameterList;
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
        if(FormParameterList!=null) FormParameterList.accept(visitor);
        if(FormalParameterDeclaration!=null) FormalParameterDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParameterList!=null) FormParameterList.traverseTopDown(visitor);
        if(FormalParameterDeclaration!=null) FormalParameterDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParameterList!=null) FormParameterList.traverseBottomUp(visitor);
        if(FormalParameterDeclaration!=null) FormalParameterDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalParameters(\n");

        if(FormParameterList!=null)
            buffer.append(FormParameterList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormalParameterDeclaration!=null)
            buffer.append(FormalParameterDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalParameters]");
        return buffer.toString();
    }
}
