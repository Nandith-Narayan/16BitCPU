package statements;

public class Instruction extends Statement{
    public String opcode;
    public Instruction(String opcode){
        this.opcode = opcode;
    }

    @Override
    public String toString() {
        return "Instruction: "+opcode;
    }
}
