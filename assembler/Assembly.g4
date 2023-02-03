grammar Assembly;

program: (statement NEWLINE)*;

statement: label
    | variable
    | simple_instruction
    | compound_instruction;

simple_instruction: OPCODE_SIMPLE;

compound_instruction: OPCODE_COMPOUND SPACE literal
    | OPCODE_COMPOUND SPACE IDENTIFIER;

label: IDENTIFIER ':';


literal: DECIMAL_LITERAL
    | HEX_LITERAL
    | BINARY_LITERAL;

variable: IDENTIFIER SPACE '=' (DECIMAL_LITERAL|HEX_LITERAL|BINARY_LITERAL);

SPACE: ' ';

DECIMAL_LITERAL: ('0d')?[0-9][0-9_]*;
HEX_LITERAL: '0x' [0-9A-Fa-f][0-9A-Fa-f_]*;
BINARY_LITERAL: '0b' [0-1][0-1_]*;

IDENTIFIER: [a-zA-Z_]([0-9a-zA-Z_])*;

NEWLINE: '\r'? '\n'
    | '\r';

WS: [ \t];

OPCODE_SIMPLE: 'NOP'
    | 'ADDA'
    | 'ADDB'
    | 'SUBA'
    | 'SUBB'
    | 'HLT'
    | 'XOR'
    | 'AND'
    | 'OR';

OPCODE_COMPOUND: 'ADD'
    | 'ADDI'
    | 'SUB'
    | 'SUBI'
    | 'LDA'
    | 'LDAI'
    | 'LDB'
    | 'LDBI'
    | 'STA'
    | 'STB'
    | 'JMP'
    | 'JC'
    | 'JZ'
    | 'JNC'
    | 'JNZ';
