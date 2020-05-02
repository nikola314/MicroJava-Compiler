// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:13:49


package rs.ac.bg.etf.pp1.ast;

public class ConstInt extends ConstIdentifier {

    private String varName;
    private Integer varValue;

    public ConstInt (String varName, Integer varValue) {
        this.varName=varName;
        this.varValue=varValue;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public Integer getVarValue() {
        return varValue;
    }

    public void setVarValue(Integer varValue) {
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
        buffer.append("ConstInt(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        buffer.append(" "+tab+varValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstInt]");
        return buffer.toString();
    }
}
