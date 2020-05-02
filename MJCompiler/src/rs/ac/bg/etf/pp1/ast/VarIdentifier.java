// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:13:49


package rs.ac.bg.etf.pp1.ast;

public class VarIdentifier implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String varName;
    private BracketsIfArray BracketsIfArray;

    public VarIdentifier (String varName, BracketsIfArray BracketsIfArray) {
        this.varName=varName;
        this.BracketsIfArray=BracketsIfArray;
        if(BracketsIfArray!=null) BracketsIfArray.setParent(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public BracketsIfArray getBracketsIfArray() {
        return BracketsIfArray;
    }

    public void setBracketsIfArray(BracketsIfArray BracketsIfArray) {
        this.BracketsIfArray=BracketsIfArray;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BracketsIfArray!=null) BracketsIfArray.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BracketsIfArray!=null) BracketsIfArray.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BracketsIfArray!=null) BracketsIfArray.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarIdentifier(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(BracketsIfArray!=null)
            buffer.append(BracketsIfArray.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarIdentifier]");
        return buffer.toString();
    }
}
