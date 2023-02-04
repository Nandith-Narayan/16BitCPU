package statements;

public class CompoundVariableInstruction extends Instruction{
    public String variableName;
    public CompoundVariableInstruction(String opcode, String variableName) {
        super(opcode);
        this.variableName = variableName;
    }

    @Override
    public String toString() {
        return "Instruction: "+opcode+" $"+this.variableName;
    }

}
