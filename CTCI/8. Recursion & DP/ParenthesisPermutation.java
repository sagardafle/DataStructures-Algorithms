/**Logic:
 * Let's consider the solution for n = 3:
(00) «0» 0(0) (0)0 000
How might we build this from n = 2?
(0) 00
We can do this by inserting a pair of parentheses inside every existing pair of parentheses, as well as one
at the beginning of the string. Any other places that we could insert parentheses, such as at the end of the
string, would reduce to the earlier cases.
So, we have the following:
 
-> (())  -> (())()) // inserted pair after 1st left paren 
         -> ((())) // inserted pair after 2nd left paren 
         -> ()(()) // inserted pair at beginning of string 
        
    ()() -> (())() // inserted pair after 1st left paren
         -> ()(()) // inserted pair after 2nd left paren
         -> ()()() // inserted pair at beginning of string
 
/*But wait- we have some duplicate pairs listed. The string () ( () ) is listed twice.
If we're going to apply this approach, we'll need to check for duplicate values before adding a string to our
list.
*/
 * 
import java.util.HashSet;
import java.util.Set;

public class ParenthesisPermutation {
    
    public static Set < String > generateParens(int remaining) {
        Set < String > set = new HashSet < String > ();
        if (remaining == 0) {
            set.add("");
        } else {
            Set < String > prev = generateParens(remaining - 1);
            for (String str: prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = insertInside(str, i);
                        /* Add s to set if it is not already in there. Note: 	
                         * HashSet automatically checks for duplicates before
                         * adding, so an explicit check is not necessary. */
                        set.add(s);
                    }
                }
                set.add("()" + str);
            }
        }
        return set;
    }
    
    public static String insertInside(String str, int leftIndex) {
        String left = str.substring(0, leftIndex + 1);
        String right = str.substring(leftIndex + 1, str.length());
        return left + "()" + right;
    }

    public static void main(String[] args) {
        Set < String > list = generateParens(2);
        System.out.println(list.size());
        for (String s: list) {
            System.out.println(s);
        }
    }
}