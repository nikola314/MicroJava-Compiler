// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:13:50


package rs.ac.bg.etf.pp1.ast;

public class RelopSame extends Relop {

    public RelopSame () {
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
        buffer.append("RelopSame(\n");

        buffer.append(tab);
        buffer.append(") [RelopSame]");
        return buffer.toString();
    }
}
