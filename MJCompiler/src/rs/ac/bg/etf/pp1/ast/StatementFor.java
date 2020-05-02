// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:13:49


package rs.ac.bg.etf.pp1.ast;

public class StatementFor extends Statement {

    private IfDesignatorStatementExists IfDesignatorStatementExists;
    private IfConditionExists IfConditionExists;
    private IfDesignatorStatementExists IfDesignatorStatementExists1;
    private Statement Statement;

    public StatementFor (IfDesignatorStatementExists IfDesignatorStatementExists, IfConditionExists IfConditionExists, IfDesignatorStatementExists IfDesignatorStatementExists1, Statement Statement) {
        this.IfDesignatorStatementExists=IfDesignatorStatementExists;
        if(IfDesignatorStatementExists!=null) IfDesignatorStatementExists.setParent(this);
        this.IfConditionExists=IfConditionExists;
        if(IfConditionExists!=null) IfConditionExists.setParent(this);
        this.IfDesignatorStatementExists1=IfDesignatorStatementExists1;
        if(IfDesignatorStatementExists1!=null) IfDesignatorStatementExists1.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public IfDesignatorStatementExists getIfDesignatorStatementExists() {
        return IfDesignatorStatementExists;
    }

    public void setIfDesignatorStatementExists(IfDesignatorStatementExists IfDesignatorStatementExists) {
        this.IfDesignatorStatementExists=IfDesignatorStatementExists;
    }

    public IfConditionExists getIfConditionExists() {
        return IfConditionExists;
    }

    public void setIfConditionExists(IfConditionExists IfConditionExists) {
        this.IfConditionExists=IfConditionExists;
    }

    public IfDesignatorStatementExists getIfDesignatorStatementExists1() {
        return IfDesignatorStatementExists1;
    }

    public void setIfDesignatorStatementExists1(IfDesignatorStatementExists IfDesignatorStatementExists1) {
        this.IfDesignatorStatementExists1=IfDesignatorStatementExists1;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfDesignatorStatementExists!=null) IfDesignatorStatementExists.accept(visitor);
        if(IfConditionExists!=null) IfConditionExists.accept(visitor);
        if(IfDesignatorStatementExists1!=null) IfDesignatorStatementExists1.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfDesignatorStatementExists!=null) IfDesignatorStatementExists.traverseTopDown(visitor);
        if(IfConditionExists!=null) IfConditionExists.traverseTopDown(visitor);
        if(IfDesignatorStatementExists1!=null) IfDesignatorStatementExists1.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfDesignatorStatementExists!=null) IfDesignatorStatementExists.traverseBottomUp(visitor);
        if(IfConditionExists!=null) IfConditionExists.traverseBottomUp(visitor);
        if(IfDesignatorStatementExists1!=null) IfDesignatorStatementExists1.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementFor(\n");

        if(IfDesignatorStatementExists!=null)
            buffer.append(IfDesignatorStatementExists.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IfConditionExists!=null)
            buffer.append(IfConditionExists.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IfDesignatorStatementExists1!=null)
            buffer.append(IfDesignatorStatementExists1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementFor]");
        return buffer.toString();
    }
}
