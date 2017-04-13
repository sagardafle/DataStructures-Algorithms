/*Complexity: O(n!) */

/* Logic: String permutation non-duplicates

1.  Try each of the letters in turn as the first letter and 
    then find all the permutations of the remaining letters using a recursive call.
    Pick 'a' first, then find all the possible combinations of (b,c) with a. (This shall give us <a,b,c>, <a,c,b>)
    
2.  When the input (remainder) string is empty, this means we have a permutation in the prefix string, 
    we add this prefix string in the output list.
*/

import java.util.*;
public class StringPermutation {
    static List < String > output;
    public static void permutation(String str) {
        output = new ArrayList < > ();
        permutationHelper("", str);
        System.out.println(output.size());
        System.out.println(output);
    }

    private static void permutationHelper(String prefix, String remainder) {
        System.out.println("prefix: "+prefix+ "\t remainder: "+remainder);
        int n = remainder.length();
        if (n == 0) output.add(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutationHelper(prefix + remainder.charAt(i), remainder.substring(0, i) + remainder.substring(i + 1));
        }
    }

    public static void main(String[] args) {
        StringPermutation sp = new StringPermutation();
        sp.permutation("abc");
    }
}