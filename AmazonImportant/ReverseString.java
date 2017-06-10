/*https://careercup.com/question?id=5664020796276736*/
public class ReverseString 
{
          public static void main(String[] args){
                    String s = "sagardafle";
                    char[] ch = s.toCharArray() ;
                    reverse(ch,0,s.length()-1);
                    System.out.println(new String(ch));
          }
    public static void reverse(char[] ch, int startIndex, int endIndex) 
    {
        if (startIndex >= endIndex)
        {
           return;
        }

        char firstLetter = ch[startIndex];
        char lastLetter = ch[endIndex];
        ch[startIndex] = lastLetter;
        ch[endIndex] = firstLetter;
        reverse(ch, ++startIndex, --endIndex);
    }
}