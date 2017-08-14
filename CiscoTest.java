/*Convert a number written in words to an integer. For example "two one three eight" -> 2138*/
import java.util.HashMap;

public class CiscoTest{
          private static HashMap<String,Integer> hashmap;
          public static void main(String[] args){
                   // System.out.println("inside main");
                   hashmap = new HashMap<String,Integer>();
                    
                    hashmap.put("zero",0);
                    hashmap.put("one",1);
                    hashmap.put("two",2);
                    hashmap.put("three",3);
                    hashmap.put("four",4);
                    hashmap.put("five",5);
                    hashmap.put("six",6);
                    hashmap.put("seven",7);
                    hashmap.put("eight",8);
                    hashmap.put("nine",9);
                    
                    int digit = convertTOdigits("zero two one three eight");
                    System.out.println("Digit is: "+digit);
          }
          
          public static int convertTOdigits(String number){
                    String[] strarray = number.split("\\s+"); // [two] [one] ...
                    
                    String output = "";
                    for(String val:strarray){
                            output +=  hashmap.get(val) ;
                    }
                    return Integer.parseInt(output);
          }
}