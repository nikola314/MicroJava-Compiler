// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:13:49


package rs.ac.bg.etf.pp1.ast;

public class StatementReturn extends Statement {

    private IfExprExists IfExprExists;

    public StatementReturn (IfExprExists IfExprExists) {
        this.IfExprExists=IfExprExists;
        if(IfExprExists!=null) IfExprExists.setParent(this);
    }

    public IfExprExists getIfExprExists() {
        return IfExprExists;
    }

    public void setIfExprExists(IfExprExists IfExprExists) {
        this.IfExprExists=IfExprExists;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfExprExists!=null) IfExprExists.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfExprExists!=null) IfExprExists.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfExprExists!=null) IfExprExists.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementReturn(\n");

        if(IfExprExists!=null)
            buffer.append(IfExprExists.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementReturn]");
        return buffer.toString();
    }
}
