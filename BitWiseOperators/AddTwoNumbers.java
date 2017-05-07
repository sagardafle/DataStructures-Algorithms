/**
 * LOGIC: 
 * In every iteration, we need to sum 3 bits: 2 bits of 2 given strings and carry. 
 * The sum bit will be 1 if, either all of the 3 bits are set or one of them is set. 
 * So we can do XOR of all bits to find the sum bit. 
 * How to find carry – carry will be 1 if any of the two bits is set. 
 * So we can find carry by taking OR of all pairs.
 * */

public class AddTwoNumbers{
         
 
// Helper method: given two unequal sized bit strings, converts them to
// same length by aadding leading 0s in the smaller String. Returns the
// the new length
public static int makeEqualLength(String str1, String str2)
{
    int len1 = str1.length();
    int len2 = str2.length();
    if (len1 < len2)
    {
        for (int i = 0 ; i < len2 - len1 ; i++)
            str1 = '0' + str1;
        return len2;
    }
    else if (len1 > len2)
    {
        for (int i = 0 ; i < len1 - len2 ; i++)
            str2 = '0' + str2;
    }
    return len1; // If len1 >= len2
}
 
// The main function that adds two bit sequences and returns the addition
public static int addBitStrings( String first, String second )
{
    int result= 0 ;  // To store the sum bits
 
    // make the lengths same before adding
    int length = makeEqualLength(first, second);
 
    int carry = 0;  // Initialize carry
 
    // Add all bits one by one
    for (int i = length-1 ; i >= 0 ; i--)
    {
        int firstBit = first.charAt(i) - '0';
        int secondBit = second.charAt(i) - '0';
 
        // boolean expression for sum of 3 bits
        int sum = (firstBit ^ secondBit ^ carry)+'0';
 
        result = (char) sum + result;
 
        // boolean expression for 3-bit addition
        carry = (firstBit & secondBit) | (secondBit & carry) | (firstBit & carry);
    }
 
    // if overflow, then add a leading 1
    if (carry == 1)
        result = '1' + result;
 
    return (int) result ;
}
 
// Driver program to test above functions
public static void main(String[] args){
    String str1 = "100";
    String str2 = "100";
 
    int sum = addBitStrings(str1, str2);
    System.out.println("sum "+sum);
    
}
}
