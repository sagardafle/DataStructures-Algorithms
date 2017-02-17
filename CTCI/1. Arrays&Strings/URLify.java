/*
Write a method to replace all spaces in a string with "%20". You may assume that the string has sufficient 
space at the end to hold the additional characters, and that you are given the "true" length of the string. 
*/
public class URLify{
    public static void main(String[] args){
        String s = "Mr John Smith   ";
        int l = 13;
        String urlified = urlifystring2(s,l);
        System.out.print("URLified string is: "+urlified);
    }
    
    /**
     * LOGIC1:
     * 1. Use string in-built function - replaceAll.
     */ 
    public static String urlifystring1(String s){
        s = s.replaceAll("\\s","%20"); 
        return s;
    }
    
     /**
     * LOGIC2:
     * 1. Convert the string to char array.
     * 2. Get the space count.
     * 3. compute newlength as newlength = length + spacecount*2
     * 4. Create new char array of size newlength.
     * 5. Now keep a pointer j for newsentence and i for old sentence.
     * 6. If the original sentence contains a space, set the respective consecutive indices values in j index by '%20' and increment j by 3. 
     *    Else, replace the character as it is from the original string. 
     * . Return new sentence.
     */ 
    public static String urlifystring2(String s, int length){
        char[] sentence = s.toCharArray();
        
        int spacecount =0;
        for(int i=0;i<s.length();i++){
            if(sentence[i] == ' ') spacecount++;
        }
        
        int newlength = length + spacecount*2;
        char[] newsentence = new char[newlength];
        int j=0;
        for(int i=0; i<length ;i++){
            if(sentence[i] == ' '){
                newsentence[j] = '%';
                newsentence[j+1] = '2';
                newsentence[j+2] = '0';
                j += 3;
            } else {
                newsentence[j] = sentence [i];
                j += 1;
            }
        }
        return new String(newsentence);
    }
}