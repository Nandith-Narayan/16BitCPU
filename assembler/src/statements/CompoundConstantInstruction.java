package statements;

public class CompoundConstantInstruction extends Instruction{
    public String constantName;
    public CompoundConstantInstruction(String opcode, String constantName) {
        super(opcode);
        this.constantName = constantName;
    }

    @Override
    public String toString() {
        return "Instruction: "+opcode+" "+this.constantName;
    }

}
