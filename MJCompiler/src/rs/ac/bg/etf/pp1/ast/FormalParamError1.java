// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:13:49


package rs.ac.bg.etf.pp1.ast;

public class FormalParamError1 extends FormParameterList {

    private FormParameterList FormParameterList;

    public FormalParamError1 (FormParameterList FormParameterList) {
        this.FormParameterList=FormParameterList;
        if(FormParameterList!=null) FormParameterList.setParent(this);
    }

    public FormParameterList getFormParameterList() {
        return FormParameterList;
    }

    public void setFormParameterList(FormParameterList FormParameterList) {
        this.FormParameterList=FormParameterList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParameterList!=null) FormParameterList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParameterList!=null) FormParameterList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParameterList!=null) FormParameterList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalParamError1(\n");

        if(FormParameterList!=null)
            buffer.append(FormParameterList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalParamError1]");
        return buffer.toString();
    }
}
