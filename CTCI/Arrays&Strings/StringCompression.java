import java.util.*;
public class StringCompression{
    public static void main(String[] args){
        String s="aabcccccaaa"; // if we need the output as "a5b1c5" , we need to use Hashmap. 
        System.out.println("Compressed String:"+optimizedcompressString(s));
    }
    
    /**
     * LOGIC: 
     * Code is self explainatory.
     */ 
     public static StringBuffer optimizedcompressString(String s){
         StringBuffer compressedString = new StringBuffer();
         int count = 1;
         for(int i=0;i<s.length();i++){
             if(i+1>=s.length() || s.charAt(i) != s.charAt(i+1)){
                 compressedString.append(s.charAt(i));
                 compressedString.append(count);
                 count = 1;
             } else {
                 count +=1;
             }
         }
         return compressedString;
     }
    
    /**
     * LOGIC:
     * Keep a track of previous and current character. 
     * If same, increment the count. 
     * Else,    1. append the previous to count 
     *          2. change previous
     *          3. set count =1
     * Make sure, we dont miss the last character in the string, so print it after for loop.
     */
     
    public static StringBuffer compressString(String s){
        StringBuffer compressedString = new StringBuffer();
        char prev = s.charAt(0) ;
        int count =0;
        for(int i=0;i<s.length();i++){
            if (s.charAt(i) == prev){
                count +=1;
            } else {
               compressedString.append(String.valueOf(prev)).append(count);
               prev = s.charAt(i);
               count = 1;
            }
        }
       compressedString.append(String.valueOf(prev)).append(count); // to add the a3. Last character otherwise will not be added. 
        return compressedString;
    }
    
    
    
    public static String compressString55(String s){
        HashMap<Character,Integer> hm = new LinkedHashMap();
        for(int i=0;i<s.length();i++){
            if(!hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i),1);
            } else {
                hm.put(s.charAt(i), hm.get(s.charAt(i)) +1);
            }
        }
        
        String compressedstr = "";
        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            compressedstr += String.valueOf(pair.getKey()) + pair.getValue();
            it.remove(); // avoids a ConcurrentModificationException
        }
        
        return compressedstr;
    }
}