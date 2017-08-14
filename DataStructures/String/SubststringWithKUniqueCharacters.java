/*https://www.youtube.com/watch?v=8AQra0p_HmI&t=38s*/

import java.util.*;
public class SubststringWithKUniqueCharacters {
    public static void main(String[] args) {
        String s = "karappa";
        int k = 2;
        System.out.println(findUnique(s, k));
    }

    public static String findUnique(String s, int k) {
        if (k == 0 || s == null || s.length() == 0)
            return "";

        if (s.length() < k)
            return s;
            
        String maxSoFar = "";

        HashMap < Character, Integer > map = new HashMap < Character, Integer > ();

        int maxLen = k;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            if (map.size() > k) {
                maxLen = Math.max(maxLen, end - start);

                while (map.size() > k) {

                    char fc = s.charAt(start);
                    if (map.get(fc) == 1) {
                        map.remove(fc);
                    } else {
                        map.put(fc, map.get(fc) - 1);
                    }

                    start++;
                }
            }

        }
        maxLen = Math.max(maxLen, s.length() - start);
        maxSoFar = s.substring(start, start + maxLen);

        System.out.println("Max length of the substring with " + k + " unique characters= " + maxLen);
        return maxSoFar;
    }
}