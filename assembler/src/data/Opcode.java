package data;

import java.util.HashMap;

public class Opcode extends Data{
    String opcode;
    public Opcode(String opcode){
        this.opcode = opcode;
    }

    public String toString(){
        return "Opcode: "+opcode;
    }

    String[] OPCODES = new String[]{"NOP", "ADDA", "ADDB", "SUBA", "SUBB", "HLT", "XOR",
                                    "AND", "OR", "ADD", "ADDI", "SUB", "SUBI", "LDA", "LDAI",
                                    "LDB", "LDBI", "STA", "STB", "JMP", "JC", "JZ", "JNC", "JNZ"};

    public int emit(HashMap<String, Integer> labelMap){
        for(int i=0;i<OPCODES.length;i++){
            if(OPCODES[i].equals(opcode)){
                return i << 9;
            }
        }
        return -888888888;
    }

}
