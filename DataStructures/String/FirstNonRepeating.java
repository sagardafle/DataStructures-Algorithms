public class FirstNonRepeating{
          public static void main(String[] args){
                    String s = "loveleetcode";
                    System.out.println("First Unique character is: " + s.charAt(firstUniqChar(s)));
          }
          
    public static int firstUniqChar(String s) {
        int[] count = new int[128];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)] +=1;
        }
        
       for(int i=0;i<s.length();i++){
           if(count[s.charAt(i)] == 1) return i;
       }
       
       return -1;
    }
}