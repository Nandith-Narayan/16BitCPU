import time

def main():
    bt = time.time()
    rom_data_first = []
    rom_data_rest = []
    for address in range(2**13):
        
        carry_in = address & 0x01
        a = (address >> 1) & 0x0F
        op = (address >> 5) & 0x07
        b = (address >> 8) & 0x0F
        
        data_first = compute_result(a, b, op, carry_in, is_first=True)
        data_rest = compute_result(a, b, op, carry_in, is_first=False)
        rom_data_first.append(data_first)
        rom_data_rest.append(data_rest)
    
    at = time.time()
    print(f"Generated ALU EEPROM data in {(at-bt)*1000:.1f} ms.")
    
    output = bytes(rom_data_first) 
    with open("ALU_ROM_DATA_FIRST.bin", "wb") as f:
        f.write(output)
    
    output = bytes(rom_data_rest) 
    with open("ALU_ROM_DATA_REST.bin", "wb") as f:
        f.write(output)
        
    print(f"Wrote {len(output)}x2 bytes.")
def compute_result(a, b, op, carry_in, is_first=False):
    # a, b <- 4 bit sections of the registers
    result = 0
    carry = 0
    if op == 0: # ADD
        result = a + b
        result += carry_in
        if (result & 0x010) > 1:
            carry = 1
    elif op == 1: # SUB
        b = (b ^ 0x0F) & 0x0F # negate B
        result = a + b + carry_in
        if is_first:
            result += 1
        if (result & 0x010) > 1:
            carry = 1
    elif op == 2: # AND
        result = a & b
    elif op == 3: # OR
        result = a | b
    elif op == 4: # XOR
        result = a ^ b
    elif op == 5: # SHLA
        result = (a << 1) + carry_in
        if (result & 0x010) > 1:
            carry = 1
    elif op == 6: # SHLB
        result = (b << 1) + carry_in
        if (result & 0x010) > 1:
            carry = 1
    elif op == 7: #
        result = a 
        

    result = result & 0x0F
    return ((carry << 4) & 0x010) + result
    
if __name__ == "__main__":
    main()