class BitWiseOperations {
    public static void main(String[] args){
        System.out.println("Hello this is a sample program for BitwiseOperators");
        
        // Test of &(and) Operator
        // answer is 1 if both bit are 1 otherwise 0
        // 3&4 i.e 011 & 100 = 000
        System.out.println("3&4: "+(3&4)); //0
       
        // Test of |(OR) Operator
        // answer is 1 if either bit is 1
        // 3|4 i.e 011 & 100 = 111
        System.out.println("3|4: " +(3 | 4)); //7
        
        // Test of ^(XOR) Operator
        // answer is 1 if both bits are different
        // 3^4 i.e 011 ^ 100 = 111
        System.out.println("3^4: " +(3 ^ 4)); //7
        
        // Test of ~(NOT) Operator
        // Inverts the bits
        // ~4 i.e 0100 = 1011 Not like this
        // It works as 4+1 = 5 and then multiply by -1 for positive integer
        // For negative integers like -2 - -2+1 = 1 
        System.out.println("~7: "+(~7));
        System.out.println("~8: "+(~8));
        
        // Test of <<(left shift) Operator
        // n << p  Shifts the bits of n left p positions. Zero bits are shifted into low order positions
        // 3 << 2
        // 3 = 101 and 2   3 << 2 = 10100
        /*
        System.out.println(Integer.toBinaryString(2 << 11)); 
        Shifts binary 2(10) by 11 times to the left. Hence: 1000000000000
        System.out.println(Integer.toBinaryString(2 << 22));    
        Shifts binary 2(10) by 22 times to the left. Hence : 100000000000000000000000
        System.out.println(Integer.toBinaryString(2 << 33)); 
        Now, int is of 4 bytes,hence 32 bits. So when you do shift by 33, it's equivalent to shift by 1. Hence : 100
        */
        System.out.println("3 << 2: " +(3 << 2));
        System.out.println("1 << 3: " +(1 << 3));
        
        // Test of >>(right shift) Operator
        // n >> p  Shifts the bits of n right p positions. 
        //If n is a 2's complement signed number, the sign bit is shifted into the high-order positions.
        // Shifted bits are lost.
        // 5 >> 2
        // 5 = 101    5 >> 2 = 001
        // 4 = 100    4 >> 2 = 001
        System.out.println("5 >> 2: " +(5 >> 2));
        System.out.println("4 >> 2: " +(4 >> 2));
        System.out.println("8 >> 2: " +(8 >> 2));
        System.out.println("1 >> 1: " +(1 >> 1));
         
        
         //System.out.println("2 >>= 1: " +(2 >>= 1));
    }
}