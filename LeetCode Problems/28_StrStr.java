public class Solution {
    public int strStr(String haystack, String needle) {
        int haystacklength = haystack.length();
        int needlelength = needle.length();
        if(needlelength > haystacklength) return -1;
        if(needlelength ==0 ) return 0;
        int needlehashcode = needle.hashCode();
        for(int i=0;i<=haystacklength-needlelength;i++){
            if(haystack.substring(i,i+needlelength).hashCode() == needlehashcode) return i;
        }
        return -1;
    }
    
    /**
     * 
     * public int strStr(String haystack, String needle) {
      for (int i = 0; ; i++) {
        for (int j = 0; ; j++) {
          if (j == needle.length()) return i;
          if (i + j == haystack.length()) return -1;
          if (needle.charAt(j) != haystack.charAt(i + j)) break;
        }
      }
    }*/
}