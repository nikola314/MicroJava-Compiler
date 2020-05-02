// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:13:49


package rs.ac.bg.etf.pp1.ast;

public class VarIdentError1 extends VarIdentifierList {

    private VarIdentifierList VarIdentifierList;

    public VarIdentError1 (VarIdentifierList VarIdentifierList) {
        this.VarIdentifierList=VarIdentifierList;
        if(VarIdentifierList!=null) VarIdentifierList.setParent(this);
    }

    public VarIdentifierList getVarIdentifierList() {
        return VarIdentifierList;
    }

    public void setVarIdentifierList(VarIdentifierList VarIdentifierList) {
        this.VarIdentifierList=VarIdentifierList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarIdentifierList!=null) VarIdentifierList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarIdentifierList!=null) VarIdentifierList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarIdentifierList!=null) VarIdentifierList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarIdentError1(\n");

        if(VarIdentifierList!=null)
            buffer.append(VarIdentifierList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarIdentError1]");
        return buffer.toString();
    }
}
