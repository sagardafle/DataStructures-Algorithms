public class LongestCommonSubsequence {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public static int longestCommonSubsequence(String A, String B) {
        int[][] dp = new int[A.length()+1][B.length()+1];
        
        for(int i=0;i<=A.length();i++){
            for(int j=0;j<=B.length();j++){
                if(i==0 || j==0) dp[i][j] = 0;
                else if(A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[A.length()][B.length()];
    }
    
    public static void main(String[] args){
              System.out.println(longestCommonSubsequence("bedaacbade","dccaeedbeb")); // "dcade" is the ans
    }
}