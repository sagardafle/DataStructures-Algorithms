/*1.2 Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.*/


/* Same as Leetcode's Valid Anagram problem */
/*Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
*/

import java.util.*;
public class CheckPermutation{
    public static void main(String[] args){
        String s = "c1ar";
        String t = "a1erc";
        boolean isPermutation = checkPermutation2(s,t);
        System.out.print("isPermutation "+isPermutation);
    }
    
    /**
     * Logic 1 :
     * 1. Keep a mask int array of size 128. 
     * 2. Traverse through 1st string. Increment the mask at respective positions.
     * 3. Traverse through 2nd string. Decrement the mask at respective positions. If the value in int mask goes below 0,
     *    that means we are decrementing a character that wasnt present in the previous string S, so s and t are not permutations of each other.
     * 4. 
     */
     
    public static boolean checkPermutation1(String s, String t){
        if(s.length()!=t.length()) return false;
        int[] mask = new int[128];
        for(int i=0;i<s.length();i++){
            int val = s.charAt(i);
            mask[val] += 1;
        }
        
        for(int i=0;i<t.length();i++){
            int val = t.charAt(i);
            mask[val] -= 1;
            if(mask[val] < 0) return false;
        }
        return true;
    }
    
    /**
     * LOGIC 2:
     * 1. Sort the two strings. 
     * 2. Compare them using equals method. 
     */ 
    public static boolean checkPermutation2(String s, String t){
         if(s.length()!=t.length()) return false;
         return sort(s).equals(sort(t));
    }
    
    public static String sort (String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    
}
