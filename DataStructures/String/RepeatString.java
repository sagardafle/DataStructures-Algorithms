 import java.util.*;
public class RepeatString {
    static String s = "sagar";
    public static void main(String args[]){
          //This replaces every null character in the char array with the original string
          String repeated = new String(new char[3]).replace("\0", s); //character '\0' is the null character. 
          System.out.println("Repeated string "+repeated);
    }
}