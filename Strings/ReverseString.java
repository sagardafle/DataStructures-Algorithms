/**
 * Created on 09/01/2016
 **/
import java.util.*;

public class ReverseString{
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String originalstring = sc.nextLine();
        char[] orignalchararray = originalstring.toCharArray();
        char temp;
        
        for (int i=0;i<originalstring.length()/2-1;i++){
            temp = orignalchararray[i];
            orignalchararray[i] = orignalchararray[orignalchararray.length-1-i];
            orignalchararray[orignalchararray.length-1-i] = temp;
        }
        
        String reversedString = String.valueOf(orignalchararray);
        System.out.println("Reversed string is: "+reversedString);
        
    }
}