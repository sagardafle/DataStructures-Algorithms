/**
 * Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
*/

/**
 * LOGIC: 
 * 1. Convert string to char array
 * 2. Swap the char array till its half position. 
 */ 

public class Solution {
    public String reverseString(String s) {
        char[] chArray = s.toCharArray();
        char temp ;
        int bounds = chArray.length;
        for(int i=0;i<bounds/2;i++){
            temp = chArray[i];
            chArray[i] = chArray[bounds-1-i];
            chArray[bounds-1-i] = temp;
        }
        return String.valueOf(chArray);
    }
}