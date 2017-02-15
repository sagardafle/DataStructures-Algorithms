public class PalindromePermutation{
    public static void main(String[] args){
        String s = "tac2o cat2";
        boolean ans = isPalindromePermutation1(s);
         System.out.print("isPalindromePermutation: "+ans);
    }
    /***
     * LOGIC 1: 
     * If a string has to be palindorme, most of the characters shall be repeated even no of times. 
     * Except, only ONE SINGLE character can be repeated once(which will be at the center of the combination)
     * 1. Create a mask array of int type. 
     * 2. Increment the value while iterating through string.
     * 3. Simulaneously, check if the mask value is odd or even. 
     * 5. If 'oddcounter' > 1, that means more than two characters were present only once and string is not palindrome.
     */ 
    
      public static boolean isPalindromePermutation1(String s){
          if(s == null) return false;
          int len = s.length();
          int[] mask = new int[128];
          int oddcounter =0;
          for(int i=0;i<s.length();i++){
              if(s.charAt(i)!=' '){ //escaping this space is very important . else mask[32] will have a value incremented.
                   int val = s.charAt(i);
                    mask[val] +=1;
                    if(mask[val]%2 == 0) oddcounter--;
                    else oddcounter++;
              }
          }
          return oddcounter <=1;
      }
}