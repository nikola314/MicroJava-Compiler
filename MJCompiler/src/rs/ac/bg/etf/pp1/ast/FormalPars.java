// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:13:49


package rs.ac.bg.etf.pp1.ast;

public class FormalPars extends FormPars {

    private FormParameterList FormParameterList;

    public FormalPars (FormParameterList FormParameterList) {
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
        buffer.append("FormalPars(\n");

        if(FormParameterList!=null)
            buffer.append(FormParameterList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalPars]");
        return buffer.toString();
    }
}
