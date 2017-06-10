/*MaxRepetitveNonContinuos Continous */
import java.io.*;
import java.util.*;
public class MaxRepetitveNonContinuos {

    public static char mostRepetitiveCharOptimized(String input) {
        int maxcount = Integer.MIN_VALUE;
        char firstMax = input.charAt(0);
        int[] count = new int[256];

        for (int i = 0; i < input.length(); i++) {
            count[input.charAt(i)] += 1;
            if (count[input.charAt(i)] > maxcount) {
                maxcount = count[input.charAt(i)];
                firstMax = input.charAt(i);
            }
        }

        return firstMax;
    }


    public static char mostRepetitiveCharUnoptimized(String input) {
        HashMap < Character, Integer > hm = new LinkedHashMap < > ();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') continue;
            if (hm.containsKey(input.charAt(i))) {
                hm.put(input.charAt(i), 1 + hm.get(input.charAt(i)));
            } else {
                hm.put(input.charAt(i), 1);
            }
        }

        System.out.println("Hashmap: " + hm);
        int maxcount = Integer.MIN_VALUE;
        Character maxoccurence = '\0';
        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if ((int) pair.getValue() > maxcount) {
                maxcount = (int) pair.getValue();
                maxoccurence = (char) pair.getKey();
            }
        }
        return maxoccurence;
    }

    public static void main(String[] args) {
        //System.out.println(mostRepetitiveCharUnoptimized("Sgaar Dlafle l"));
        System.out.println(mostRepetitiveCharOptimized("Sgaar Dlafle l"));
    }
}