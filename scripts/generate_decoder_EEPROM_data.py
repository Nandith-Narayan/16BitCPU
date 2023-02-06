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
    rom_data_1 = []
    rom_data_2 = []
    rom_data_3 = []
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
        b1, b2, b3 = make_control_words(bits_to_enable)
        rom_data_1.append(b1)
        rom_data_2.append(b2)
        rom_data_3.append(b3)

    at = time.time()
    print(f"Generated Decoder EEPROM data in {(at-bt)*1000:.1f} ms.")
    
    output = bytes(rom_data_1) 
    with open("DECODER_ROM_DATA_1.bin", "wb") as f:
        f.write(output)
    output = bytes(rom_data_2) 
    with open("DECODER_ROM_DATA_2.bin", "wb") as f:
        f.write(output)
    output = bytes(rom_data_3)
    with open("DECODER_ROM_DATA_3.bin", "wb") as f:
        f.write(output)
        
    print(f"Wrote {len(output)}x3 bytes.")

def make_control_words(enable_bits):
    control_word = [0]*24
    for bit in enable_bits:
        control_word[bit] = 1

    
    control_word = ("".join([str(i) for i in control_word]))    
    byte_1 = int(control_word[:8][::-1],2)
    byte_2 = int(control_word[8:16][::-1],2)
    byte_3 = int(control_word[16:24][::-1],2)
        
        
    return (byte_1&0x0FF, byte_2&0x0FF, byte_3&0x0FF)

def compute_control_step(opcode, step, zero_flag, carry_flag):
    if step == 0: 
        return [PC_OUT, RAM_ADDR]
    if step == 1: 
        return [RAM_OUT, INST_IN, PC_ENABLE]
        
    if opcode == "NOP":
        return [RESET_MICRO_STEP]
    if opcode == "ADDA":
        return ADDA(step)
    if opcode == "ADDB":
        return ADDB(step)
    if opcode == "SUBA":
        return SUBA(step)
    if opcode == "SUBB":
        return SUBB(step)
    if opcode == "XOR":
        return XOR(step)
    if opcode == "OR":
        return OR(step)
    if opcode == "AND":
        return AND(step)
    if opcode == "ADDI":
        return ADDI(step)
    if opcode == "ADD":
        return ADD(step)
    if opcode == "SUBI":
        return SUBI(step)
    if opcode == "SUB":
        return SUB(step)
    if opcode == "LDA":
        return LDA(step)
    if opcode == "LDB":
        return LDB(step)
    if opcode == "LDAI":
        return LDAI(step)
    if opcode == "LDBI":
        return LDBI(step)
    if opcode == "STA":
        return STA(step)
    if opcode == "STB":
        return STB(step)
    if opcode == "JMP":
        return JMP(step)
    if opcode == "JC":
        return JC(step, carry_flag)
    if opcode == "JZ":
        return JZ(step, zero_flag)
    if opcode == "JNC":
        return JNC(step, carry_flag)
    if opcode == "JNZ":
        return JNZ(step, zero_flag)
        
    print(f"OPCODE: {opcode} not implemented")
    
    return [RESET_MICRO_STEP]

def JMP(step):
    if step == 2:
        return [PC_OUT, RAM_ADDR]
    if step == 3:
        return [RAM_OUT, PC_IN]    
    
    return [RESET_MICRO_STEP] 

def JC(step, carry):
    if carry == 1:
        if step == 2:
            return [PC_ENABLE]
        if step == 3:
            return [RESET_MICRO_STEP]
    else:
        if step == 2:
            return [PC_OUT, RAM_ADDR]
        if step == 3:
            return [RAM_OUT, PC_IN]    
    
    return [RESET_MICRO_STEP] 

def JZ(step, zero):
    if zero ==1:
        if step == 2:
            return [PC_ENABLE]
        if step == 3:
            return [RESET_MICRO_STEP]
    else:
        if step == 2:
            return [PC_OUT, RAM_ADDR]
        if step == 3:
            return [RAM_OUT, PC_IN]    
    
    return [RESET_MICRO_STEP]
    
def JNC(step, carry):
    if carry == 0:
        if step == 2:
            return [PC_ENABLE]
        if step == 3:
            return [RESET_MICRO_STEP]
    else:
        if step == 2:
            return [PC_OUT, RAM_ADDR]
        if step == 3:
            return [RAM_OUT, PC_IN]    
    
    return [RESET_MICRO_STEP] 

def JNZ(step, zero):
    if zero == 0:
        if step == 2:
            return [PC_ENABLE]
        if step == 3:
            return [RESET_MICRO_STEP]
    else:
        if step == 2:
            return [PC_OUT, RAM_ADDR]
        if step == 3:
            return [RAM_OUT, PC_IN]    
    
    return [RESET_MICRO_STEP] 

def STA(step):
    if step == 2:
        return [PC_OUT, RAM_ADDR]
    if step == 3:
        return [RAM_OUT, RAM_ADDR, PC_ENABLE]
    if step == 4:
        return [A_OUT, RAM_IN]
        
    return [RESET_MICRO_STEP] 
    
def STB(step):
    if step == 2:
        return [PC_OUT, RAM_ADDR]
    if step == 3:
        return [RAM_OUT, RAM_ADDR, PC_ENABLE]
    if step == 4:
        return [B_OUT, RAM_IN]
        
    return [RESET_MICRO_STEP]     
    
def LDAI(step):
    if step == 2:
        return [PC_OUT, RAM_ADDR]
    if step == 3:
        return [RAM_OUT, A_IN, PC_ENABLE]
        
    return [RESET_MICRO_STEP] 

def LDBI(step):
    if step == 2:
        return [PC_OUT, RAM_ADDR]
    if step == 3:
        return [RAM_OUT, B_IN, PC_ENABLE]
        
    return [RESET_MICRO_STEP] 

def LDB(step):
    if step == 2:
        return [PC_OUT, RAM_ADDR]
    if step == 3:
        return [RAM_OUT, RAM_ADDR, PC_ENABLE]
    if step == 4:
        return [RAM_OUT, B_IN]
    
    return [RESET_MICRO_STEP]

def LDA(step):
    if step == 2:
        return [PC_OUT, RAM_ADDR]
    if step == 3:
        return [RAM_OUT, RAM_ADDR, PC_ENABLE]
    if step == 4:
        return [RAM_OUT, A_IN]
    
    return [RESET_MICRO_STEP]    

def ADD(step):
    if step == 2:
        return [PC_OUT, RAM_ADDR]
    if step == 3:
        return [RAM_OUT, RAM_ADDR, PC_ENABLE]
    if step == 4:
        return [RAM_OUT, B_IN]
    if step == 5:
        return [ALU_OUT, A_IN]
        
    return [RESET_MICRO_STEP]     
    
    
def ADDI(step):
    if step == 2:
        return [PC_OUT, RAM_ADDR]
    if step == 3:
        return [RAM_OUT, B_IN, PC_ENABLE]
    if step == 4:
        return [ALU_OUT, A_IN]
        
    return [RESET_MICRO_STEP] 

def SUB(step):
    if step == 2:
        return [PC_OUT, RAM_ADDR]
    if step == 3:
        return [RAM_OUT, RAM_ADDR, PC_ENABLE]
    if step == 4:
        return [RAM_OUT, B_IN]
    if step == 5:
        return [ALU_OP1, ALU_OUT, A_IN]
        
    return [RESET_MICRO_STEP]     
    
    
def SUBI(step):
    if step == 2:
        return [PC_OUT, RAM_ADDR]
    if step == 3:
        return [RAM_OUT, B_IN, PC_ENABLE]
    if step == 4:
        return [ALU_OP1, ALU_OUT, A_IN]
        
    return [RESET_MICRO_STEP]      

def AND(step):
    if step == 2:
        return [ALU_OP2, ALU_OUT, A_IN]
        
    return [RESET_MICRO_STEP]  
    
def XOR(step):
    if step == 2:
        return [ALU_OP3, ALU_OUT, A_IN]
        
    return [RESET_MICRO_STEP]
    
def OR(step):
    if step == 2:
        return [ALU_OP1, ALU_OP2, ALU_OUT, A_IN]
        
    return [RESET_MICRO_STEP]     
    
    
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