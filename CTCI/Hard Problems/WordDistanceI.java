/**
 * 
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = "coding", word2 = "practice", return 3. Given word1 = "makes", word2 = "coding", return 1.

Note
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/


class WordDistanceI {
public static int shortestDistance(String[] words, String word1, String word2) {
        int n = words.length, idx1 = -1, idx2 = -1, dist = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (words[i] == word1) idx1 = i;
            else if (words[i] == word2) idx2 = i;
            if (idx1 != -1 && idx2 != -1)
                dist = Math.min(dist, Math.abs(idx1 - idx2));
        }
        return dist;
    }
    
    public static void main(String[] args){
              String[] words = {"practice", "makes", "perfect", "coding", "makes"};
              int dis = shortestDistance(words, "coding","practice");
              System.out.print("Distance: "+dis);
    }
}