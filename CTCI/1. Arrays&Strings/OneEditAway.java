/*1.5 One Away: 
There are three types of edits that can be performed on strings: insert a character, remove a character and replace a character. 
Given two strings, write a function to check if they are within one edit of each other.
*/
public class OneEditAway{
    public static void main(String[] args){
        String s="pales";
        String t="pale";
        boolean isoneeditaway = oneEditAway(s,t);
        System.out.println("isoneeditaway "+isoneeditaway);
    }
    public static boolean oneEditAway(String s, String t){
        if(s.length() == t.length()) return oneReplaceAway(s,t);
        else if (s.length()+1 == t.length()) return oneInsertAway(s,t);
        else if (s.length() == t.length()+1) return oneDeleteAway(s,t);
        else return false;
    }
    
    /**
     * Compare the strings one by one. 
     * If unmatch is found first time, set the flag to true. 
     * If unmatch is found second time, return false.
     */ 
     / S: "pales"  T:"bales"
    public static boolean oneReplaceAway(String s, String t){
         System.out.println("One replace away");
        boolean foundonediff =false ; 
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != t.charAt(i)){
                if(foundonediff) return false;
                foundonediff = true;
            } 
        }
        return true;
    }
    
    // S: "png"  T:"apng"
    /** LOGIC:
     *  1. Declare two index variables for both the strings. Traverse through both string simultaneously. 
     *  2. Compare each character. 
     *  3. If no match is found, increment ONLY the larger string index; else increment both the pointers.
     *  4. If no match is found, more than once, return false.
     */ 
    public static boolean oneInsertAway(String s, String t){
        System.out.println("One insert away");
        int index1, index2;
        index1 = index2 = 0;
        boolean onenonmatch = false;
        while(index1<s.length() && index2<t.length()){
            if(s.charAt(index1)!=t.charAt(index2)){
                if(onenonmatch) return false;
                index2++; //increment the second index pointing to larger string, t.
                onenonmatch = true;
            }
            index1++;
            index2++;
        }
        return true;
    }
    
    // String s="abcd";  String t="abd";
     /** LOGIC:
     *   Similar to above logic but instead of incrementing the target string t, we will increment the source string s as s>t. 
     *  
     */ 
    public static boolean oneDeleteAway(String s, String t){
         System.out.println("One delete away");
         
        int index1, index2;
        index1 = index2 = 0;
        boolean onenonmatch = false;
        while(index1<s.length() && index2<t.length()){
            if(s.charAt(index1)!=t.charAt(index2)){
                if(onenonmatch) return false;
                index1++;  //increment the first index pointing to larger string, s.
                onenonmatch = true;
            }
            index1++;
            index2++;
        }
        return true;
    }
    
}