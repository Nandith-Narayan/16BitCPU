package data;

public class Opcode extends Data{
    String opcode;
    public Opcode(String opcode){
        this.opcode = opcode;
    }

    public String toString(){
        return "Opcode: "+opcode;
    }
}
