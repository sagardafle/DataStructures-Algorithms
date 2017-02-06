import java.util.*;
import java.io.*;

public class FindMinimum {
    
    public static void main(String args[]){
  
        System.out.println("Enter no:: ");
		Scanner sc = new Scanner(System.in);
		int st = sc.nextInt();
		System.out.println();
		int result = findMinimum(st);
		System.out.println("========================");
		System.out.println("The answer is: " + result);
    }class FindMinimumVariant {
    public static void main(String[] args){
        solution(623315);
    }
    public static int solution(int X) {
        // write your code in Java SE 8
        String ns = String.valueOf(X);
        int len = ns.length();  // Length of the integer
        int i=0;
        int max = Integer.MIN_VALUE;
        int average = 0;
        int avg = 0;
        int number;
        String prefix="";
        while(i<len-1)
        {
            if(i!=0){
                 prefix = ns.substring(0,i);
            }
            //average = (Character.getNumericValue(ns.charAt(i))+Character.getNumericValue(ns.charAt(i+1)))/2;
            System.out.println("zzzzz" +((ns.charAt(i)-'0')+(ns.charAt(i+1)-'0'))/2.0);
            average = (int) Math.round(((ns.charAt(i)-'0')+(ns.charAt(i+1)-'0'))/2.0);
            System.out.println("valuue of i ---"+(ns.charAt(i)-'0'));
            System.out.println("valuee 0f i+1 -"+(ns.charAt(i+1)-'0'));
            
            avg=Math.round(average);
            String remaining = ns.substring(i+2,len);
            remaining = prefix+avg + remaining;
            System.out.println(remaining);
            if(Integer.parseInt(remaining)>=max)
                max = Integer.parseInt(remaining); 
            i++;  //Incrementing the counter
        }
        return max;
    }
}
    
    public static int findMinimum(int n){
        // Integer to keep track of 3 consequent integers
        int low=0,mid=0,high=0;
        String ns = String.valueOf(n);
        int len = ns.length();   // Length of the integer
        int i=0;
        while(i<len-2){             
            if((ns.charAt(i)>=ns.charAt(i+1)) && (ns.charAt(i+1) > ns.charAt(i+2))) // checking whether low>=mid>high
            {
                low=i;
                mid=i+1;
                high=i+2;
                break;
            }
            i++; //Incrementing the counter
        }
        StringBuilder sb = new StringBuilder(ns);
        if(low!=mid)   // We found 3 consecutive decreasing integers
        {
            sb.deleteCharAt(mid); // Swapping middle one with low
        }
        // Swapping last two non significant digits
        else
        {
            if(ns.charAt(len-2)>ns.charAt(len-1))
            {
                sb.deleteCharAt(len-1);
            }
            else
            {
                sb.deleteCharAt(len-2);
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}