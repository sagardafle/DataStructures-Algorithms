/**Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321 
**/
public class Solution {
    public int reverse(int x) {
        if(x == 0 || x>=Integer.MAX_VALUE || x<=Integer.MIN_VALUE) return 0;
        boolean isNegative = false;
        if(x<0) {
            isNegative = true;
            x = Math.abs(x);
        }
        long reversednumber = 0;
       while(x>0){
           reversednumber = reversednumber*10 + x%10;
           x = x/10;
       }
       if(isNegative) reversednumber = reversednumber*-1;
       if (reversednumber>=Integer.MAX_VALUE || reversednumber<=Integer.MIN_VALUE) return 0;
       return (int) reversednumber;
    }
} 