package statements;

public class CompoundLiteralInstruction extends Instruction{
    public int literal;
    public CompoundLiteralInstruction(String opcode, int literal) {
        super(opcode);
        this.literal = literal;
    }

    @Override
    public String toString() {
        return "Instruction: "+opcode+" "+this.literal;
    }

}
