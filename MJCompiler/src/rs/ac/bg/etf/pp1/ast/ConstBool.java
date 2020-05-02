// generated with ast extension for cup
// version 0.8
// 29/0/2020 2:2:12


package rs.ac.bg.etf.pp1.ast;

public class ConstBool extends ConstIdentifier {

    private String varName;
    private Boolean varValue;

    public ConstBool (String varName, Boolean varValue) {
        this.varName=varName;
        this.varValue=varValue;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public Boolean getVarValue() {
        return varValue;
    }

    public void setVarValue(Boolean varValue) {
        this.varValue=varValue;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstBool(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        buffer.append(" "+tab+varValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstBool]");
        return buffer.toString();
    }
}
