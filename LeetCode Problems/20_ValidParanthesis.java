public class Solution {
    public boolean isValid(String str) {
        if(str == null || str.length()%2 !=0) return false;
        Stack<Character> s = new Stack<>();
        
        for (char ch: str.toCharArray()){
                if(ch == '{'){
                    s.push('}');
                } 
                else if (ch == '[') {
                    s.push(']');
                }
                else if (ch == '('){
                    s.push(')');
                } 
              else if (s.isEmpty() || s.pop() != ch)
		        	return false;
	        }
	        return s.isEmpty();
    }
}