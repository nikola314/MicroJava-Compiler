// generated with ast extension for cup
// version 0.8
// 3/1/2020 0:13:49


package rs.ac.bg.etf.pp1.ast;

public class ProgramDeclarations extends ProgramDeclarationList {

    private ProgramDeclarationList ProgramDeclarationList;
    private ProgramDeclaration ProgramDeclaration;

    public ProgramDeclarations (ProgramDeclarationList ProgramDeclarationList, ProgramDeclaration ProgramDeclaration) {
        this.ProgramDeclarationList=ProgramDeclarationList;
        if(ProgramDeclarationList!=null) ProgramDeclarationList.setParent(this);
        this.ProgramDeclaration=ProgramDeclaration;
        if(ProgramDeclaration!=null) ProgramDeclaration.setParent(this);
    }

    public ProgramDeclarationList getProgramDeclarationList() {
        return ProgramDeclarationList;
    }

    public void setProgramDeclarationList(ProgramDeclarationList ProgramDeclarationList) {
        this.ProgramDeclarationList=ProgramDeclarationList;
    }

    public ProgramDeclaration getProgramDeclaration() {
        return ProgramDeclaration;
    }

    public void setProgramDeclaration(ProgramDeclaration ProgramDeclaration) {
        this.ProgramDeclaration=ProgramDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgramDeclarationList!=null) ProgramDeclarationList.accept(visitor);
        if(ProgramDeclaration!=null) ProgramDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramDeclarationList!=null) ProgramDeclarationList.traverseTopDown(visitor);
        if(ProgramDeclaration!=null) ProgramDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramDeclarationList!=null) ProgramDeclarationList.traverseBottomUp(visitor);
        if(ProgramDeclaration!=null) ProgramDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDeclarations(\n");

        if(ProgramDeclarationList!=null)
            buffer.append(ProgramDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ProgramDeclaration!=null)
            buffer.append(ProgramDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDeclarations]");
        return buffer.toString();
    }
}
