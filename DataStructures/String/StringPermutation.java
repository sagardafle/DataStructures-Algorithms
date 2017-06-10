import java.util.*;
public class StringPermutation{
          static List<String> result = new ArrayList<>();
          public static void main(String[] args){
                    String s = "abc";
                    permutation("",s,result);
                    System.out.println("Permutations: "+result.size());
          }
          
          private static void permutation(String prefix, String suffix, List<String> result){
                    System.out.println("Prefix: "+prefix+" Suffix:"+suffix+" result: "+result);
                    for(int i=0;i<suffix.length();i++){
                          if(suffix.length() == 0){
                              result.add(prefix);
                    } else {
                              permutation(prefix+suffix.charAt(i),                                  //PREFIX str.substring(0,0) outputs nothing.
                              suffix.substring(0,i) + suffix.substring(i+1, suffix.length()),       //SUFFIX
                              result);
                    }    
             }
          }
}