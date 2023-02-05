import time

def main():
    bt = time.time()
    rom_data = []
    for address in range(2**13):
        full_a = address & 0x01F
        full_b = (address >> 8) & 0x01F
        
        op = (address >> 5) & 0x07
        if op == 1: # SUB
            # 2's complement B:
            full_b = full_b ^ 0x01F
            full_b += 1
            full_b = full_b & 0x01F
        
        a = (full_a >> 1) & 0x0F
        b = (full_b >> 1) & 0x0F
        
        carry_in_a = full_a & 0x01
        carry_in_b = full_b & 0x01
        
        data = compute_result(a, b, op, carry_in_a, carry_in_b)
        rom_data.append(data)
    
    at = time.time()
    print(f"Generated ALU EEPROM data in {(at-bt)*1000:.1f} ms.")
    
    output = bytes(rom_data) 
    with open("ALU_ROM_DATA.bin", "wb") as f:
        f.write(output)
        
    print(f"Wrote {len(output)} bytes.")
def compute_result(a, b, op, carry_in_a, carry_in_b):
    # a, b <- 4 bit sections of the registers
    result = 0
    carry = 0
    if op == 0 or op == 1: # ADD or SUB remember to 2's complement the entire 16bit value of register B
        result = a + b
        if carry_in_a == 1 and carry_in_b == 1:
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
        result = (a << 1) + carry_in_a
        if (result & 0x010) > 1:
            carry = 1
    elif op == 6: # SHLB
        result = (b << 1) + carry_in_b
        if (result & 0x010) > 1:
            carry = 1
    elif op == 7: #
        result = a 
        

    result = result & 0x0F
    return ((carry << 4) & 0x010) + result
    
if __name__ == "__main__":
    main()