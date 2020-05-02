// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:13:50


package rs.ac.bg.etf.pp1.ast;

public class DesignatorExpr extends Designator {

    private DesignatorExprLR DesignatorExprLR;
    private Expr Expr;

    public DesignatorExpr (DesignatorExprLR DesignatorExprLR, Expr Expr) {
        this.DesignatorExprLR=DesignatorExprLR;
        if(DesignatorExprLR!=null) DesignatorExprLR.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public DesignatorExprLR getDesignatorExprLR() {
        return DesignatorExprLR;
    }

    public void setDesignatorExprLR(DesignatorExprLR DesignatorExprLR) {
        this.DesignatorExprLR=DesignatorExprLR;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorExprLR!=null) DesignatorExprLR.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorExprLR!=null) DesignatorExprLR.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorExprLR!=null) DesignatorExprLR.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorExpr(\n");

        if(DesignatorExprLR!=null)
            buffer.append(DesignatorExprLR.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorExpr]");
        return buffer.toString();
    }
}
