import time

OPCODES = ["NOP", "ADDA", "ADDB", "SUBA", "SUBB", "HLT", "XOR",
           "AND", "OR", "ADD", "ADDI", "SUB", "SUBI", "LDA", "LDAI",
           "LDB", "LDBI", "STA", "STB", "JMP", "JC", "JZ", "JNC", "JNZ"]

A_IN = 0
A_OUT = 1
B_IN = 2
B_OUT = 3
RAM_IN = 4
RAM_OUT = 5
RAM_ADDR = 6
PC_IN = 7

PC_OUT = 8
PC_ENABLE = 9
ALU_OUT = 10
ALU_OP1 = 11
ALU_OP2 = 12
ALU_OP3 = 13
FLAGS_IN = 14
INST_IN = 15
RESET_MICRO_STEP = 16

def main():
    bt = time.time()
    rom_data = []
    for address in range(2**12):
        opcode = address & 0x03F
        if opcode < len(OPCODES):
            opcode = OPCODES[opcode]
        else:
            opcode = "NOP"
        
        step = (address >> 6) & 0x0F
        zero_flag = (address >> 10) & 0x01
        carry_flag = (address >> 11) & 0x01
        
        bits_to_enable = compute_control_step(opcode, step, zero_flag, carry_flag)
        
        
    at = time.time()
    print(f"Generated Decoder EEPROM data in {(at-bt)*1000:.1f} ms.")
    
    output = bytes(rom_data) 
    with open("DECODER_ROM_DATA.bin", "wb") as f:
        f.write(output)
        
    print(f"Wrote {len(output)} bytes.")

def compute_control_step(opcode, step, zero_flag, carry_flag):
    if step == 0: 
        return [PC_OUT, RAM_ADDR]
    if step == 1: 
        return [RAM_OUT, INST_IN, PC_ENABLE]
        
    if opcode == "NOP":
        return []
    if opcode == "ADDA":
        return ADDA(step)
    if opcode == "ADDB":
        return ADDB(step)
    if opcode == "SUBA":
        return SUBA(step)
    if opcode == "SUBB":
        return SUBB(step)
        
    
    print(f"OPCODE: {opcode} not implemented")
    
    return []
    
def ADDA(step):
    if step == 2:
        return [ALU_OUT, A_IN]
        
    return [RESET_MICRO_STEP]

def ADDB(step):
    if step == 2:
        return [ALU_OUT, B_IN]
        
    return [RESET_MICRO_STEP]
    
def SUBA(step):
    if step == 2:
        return [ALU_OP1, ALU_OUT, A_IN]
        
    return [RESET_MICRO_STEP]

def SUBB(step):
    if step == 2:
        return [ALU_OP1, ALU_OUT, B_IN]
        
    return [RESET_MICRO_STEP]
    
    
    
    

if __name__ == "__main__":
    main()