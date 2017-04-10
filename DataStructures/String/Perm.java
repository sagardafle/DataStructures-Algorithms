import java.util.*;
public class Perm {
    static List < String > output;
    public static void main(String[] args) {
        Perm obj = new Perm();
        output = new ArrayList < > ();
        obj.permutation("ABC");
        System.out.print(output);
    }
    public void permutation(String x) {
        helperfunction("", x);
    }

    public void helperfunction(String prefix, String input) {
        System.out.println("Prefix: "+prefix+" input: "+input);
        int n = input.length();
        if (n == 0) {
                  System.out.println("==Adding "+prefix+" to the list==");
                  output.add(prefix); //BASE CASE 
        }
        for (int i = 0; i < input.length(); i++) {
            helperfunction(prefix + input.charAt(i), input.substring(0, i) + input.substring(i + 1, n));
        }
    }
}