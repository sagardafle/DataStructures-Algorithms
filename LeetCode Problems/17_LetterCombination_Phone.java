/**
 * LOGIC : 
 * 1. Declare a linkedlist to store the output.
 * 2. Create a string array to hold telephone characters corresponding to the digits (as given).
 * 3. Iterate over input digits string. 
 *    3.1 For the first digit, add the respective characters in linkedlist. 
 *    3.2 Pop the element from LL. Now, append this element with the characters in 2nd digit one by one and add in the LL again.
 * 
 */
 
public class Solution {
    public List<String> letterCombinations(String digits) {
    LinkedList<String> ans = new LinkedList<String>();
    if(digits.length () == 0 || digits == null) return ans;
    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ans.add("");
    for(int i =0; i<digits.length();i++){
        int x = Character.getNumericValue(digits.charAt(i));
        System.out.println("=========x "+x);
        while(ans.peek().length()==i){ // ans.peek() returns the value f head element. So this loop will run only till the length of the first string corresponnding to first digit.
            String t = ans.remove();
            System.out.println("t "+t);
            for(char s : mapping[x].toCharArray()){
                System.out.println("t+s  "+t+s);
                        ans.add(t+s);
            }
        }
    }
    return ans;
}
}