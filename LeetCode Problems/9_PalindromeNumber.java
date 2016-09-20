/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */ 

public class Solution {
    public boolean isPalindrome(int x) {
         /**
         * With an extra space
         */ 
        // String str =  String.valueOf(x);
        // boolean isPalindrome = true;
        // for(int i=0;i<str.length()/2;i++){
        //     if(str.charAt(i) != str.charAt(str.length()-i-1)){
        //         isPalindrome = false;
        //     } 
        // }
        // return isPalindrome;
        
        /**
         * Simple reverse the integer and compare with original value.
         */ 
        if(x < 0) return false;
        int y = x;
        int res = 0;
        while(y != 0) {
            res = res * 10 + y % 10;
            y /= 10;
        }
        return x == res;
    }
}