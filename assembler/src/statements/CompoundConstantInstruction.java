package statements;

public class CompoundConstantInstruction extends Instruction{
    String constantName;
    int constantValue;
    public CompoundConstantInstruction(String opcode, String constantName) {
        super(opcode);
        this.constantName = constantName;
    }

    @Override
    public String toString() {
        return "Instruction: "+opcode+" "+this.constantName;
    }

    public void applyConstant(String name, int value){
        this.constantName = name;
        this.constantValue = value;
    }

}
