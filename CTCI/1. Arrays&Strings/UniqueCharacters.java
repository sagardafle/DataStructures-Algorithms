/*1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters. 
What if you cannot use additional data structures?
*/

/** LOGIC: 
 * 1. Keep a BOOLEAN mask array. 
 * 2. As we traverse through the string, we set the respective character's mask to true.
 * 3. If the character has already been set true, we return false.
 * 
 */ 
public class UniqueCharacters{
    public static void main(String[] args){
        String s = "sagrdfle";
        boolean isUnique = checkNonUniqueCharacters(s);
        System.out.print("Isunique "+isUnique);
    }
    
    public static boolean checkNonUniqueCharacters(String s){
        if(s.length()>128) return false; //some characters were repeated
        boolean[] mask = new boolean[128];
        for(int i=0;i<s.length();i++){
            int value = s.charAt(i);
            if(mask[value]) return false; //return false as the character is already present
            mask[value] = true;  
        }
        return true;
    }
}