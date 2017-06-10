import java.util.*;
public class MaxPalindrome{
        public static void main(String[] args){
        String ip = "abaccddccefe";
        String[] ipArr = ip.split("");
        Map<String, Integer> charFreqStMap = new HashMap<String, Integer>(); 
        
        Integer maxPal = 0;
        for(int i = 1; i < ip.length(); i++) {
            String a = ipArr[i];
            if(charFreqStMap.containsKey(a)) {
                Integer prevCount = charFreqStMap.get(a);
                charFreqStMap.put(a, prevCount + 1);
                if(maxPal < prevCount + 1) {
                    maxPal = prevCount + 1;
                }
            } else {
                charFreqStMap.put(a, 1);
            }
        }
        if(maxPal > 0) {
            System.out.println("Max Length Palindrome String is: " + ++maxPal);
        } else {
            System.out.println("Palindrome not present in input string..");
        }        
        }
}