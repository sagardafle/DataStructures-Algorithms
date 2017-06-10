public class NumberPalindrome {
          public static void main(String[] args){
                    System.out.println(check(5));        
          }
          
          public static boolean check(int num){
                    int orignalNumber = num;
                    int reverseNumber = 0;
                    System.out.println("hwllp");
                    while(orignalNumber!=0){
                              reverseNumber = reverseNumber << 1;
                              if((orignalNumber & 1) == 1){
                                        reverseNumber |= 1;
                              }
                              orignalNumber >>= 1;
                              System.out.println(orignalNumber);
                    }
                    
                    return num == reverseNumber;
          }
          
          
}