// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:13:50


package rs.ac.bg.etf.pp1.ast;

public class FactorDesig extends Factor {

    private Designator Designator;
    private IfActParsExist IfActParsExist;

    public FactorDesig (Designator Designator, IfActParsExist IfActParsExist) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.IfActParsExist=IfActParsExist;
        if(IfActParsExist!=null) IfActParsExist.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public IfActParsExist getIfActParsExist() {
        return IfActParsExist;
    }

    public void setIfActParsExist(IfActParsExist IfActParsExist) {
        this.IfActParsExist=IfActParsExist;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(IfActParsExist!=null) IfActParsExist.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(IfActParsExist!=null) IfActParsExist.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(IfActParsExist!=null) IfActParsExist.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesig(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IfActParsExist!=null)
            buffer.append(IfActParsExist.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesig]");
        return buffer.toString();
    }
}
