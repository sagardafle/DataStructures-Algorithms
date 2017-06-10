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
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            if (map.size() > k) {
                maxLen = Math.max(maxLen, i - left);

                while (map.size() > k) {

                    char fc = s.charAt(left);
                    if (map.get(fc) == 1) {
                        map.remove(fc);
                    } else {
                        map.put(fc, map.get(fc) - 1);
                    }

                    left++;
                }
            }

        }
        maxLen = Math.max(maxLen, s.length() - left);
        maxSoFar = s.substring(left, left + maxLen);

        System.out.println("Max length of the substring with " + k + " unique characters= " + maxLen);
        return maxSoFar;
    }
}