/*1.9 String Rotation: Assume you have a method isSubstring which checks if one word is a substring of another. 
Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only once call to isSubstring 
(e.g., "waterbottle" is a rotation of "erbottlewat").
*/

/** LOGIC:
     * Create a twin of original string. 
     * If the other string is rotated, it has to be present as a substring in the twin string.
     * 
     * Eg: s="sagar"; t="arsag"
     * twin = "sag'arssag'ar" //twin will contain t.
     * 
     */

public class StringRotation{
    public static void main(String[] args){
        String s = "watterbottle";
        String t = "tlewatterbot";
        System.out.println("Is String rotated "+isRotation(s,t));
    }
    
    
    public static boolean isRotation(String s, String t) {
         
         if(s.length()!=t.length()) return false;
         
         String twin = s+s; 
         return isSubstring(twin,t);
    }
    
    public static boolean isSubstring(String twin, String t){
        return twin.contains(t);
    }
}