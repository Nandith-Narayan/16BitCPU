package statements;

public class CompoundConstantInstruction extends Instruction{
    String constantName;
    int constantValue;
    boolean hasValue = false;

    public CompoundConstantInstruction(String opcode, String constantName) {
        super(opcode);
        this.constantName = constantName;
    }

    @Override
    public String toString() {
        if(hasValue) {
            return "Instruction: " + opcode + " " + this.constantValue;
        }else{
            return "Instruction: " + opcode + " " + this.constantName;
        }
    }

    public void applyConstant(String name, int value){
        if(this.constantName.equals(name)) {
            this.constantValue = value;
            hasValue = true;
        }
    }

}
