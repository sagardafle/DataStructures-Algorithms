public class CiscoTest1{

public static void main(String[] args){
          String s = "Sa!gar Dafle is interviewing at Ci;:.sco";
          System.out.pintln(findLongestWord(s));
   }
   
   public String findLongestWord(String s){
             int maxlen = 0;
             String[] strarray = s.split("\\s+");
             for(int i=0;i<strarray.length;i++){
                       int charcount = 0;
                       char[] charray = strarray[i].toCharArray();
                       for(Character c:charray){
                                 if(!c.^[,.'':;\n])){
                                      charcount = 0;
                                      break; 
                                 } else {
                                      charcount ++;
                                 }
                       }
                       if(charcount > maxlen) maxlen = charcount;
                      // continue;
             }
             System.out.println("ML: "+maxlen);
             return null;
   }
}