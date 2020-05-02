// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:13:50


package rs.ac.bg.etf.pp1.ast;

public class FactorOther extends Factor {

    private Type Type;
    private IfNewArray IfNewArray;

    public FactorOther (Type Type, IfNewArray IfNewArray) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.IfNewArray=IfNewArray;
        if(IfNewArray!=null) IfNewArray.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public IfNewArray getIfNewArray() {
        return IfNewArray;
    }

    public void setIfNewArray(IfNewArray IfNewArray) {
        this.IfNewArray=IfNewArray;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(IfNewArray!=null) IfNewArray.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(IfNewArray!=null) IfNewArray.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(IfNewArray!=null) IfNewArray.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorOther(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IfNewArray!=null)
            buffer.append(IfNewArray.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorOther]");
        return buffer.toString();
    }
}
