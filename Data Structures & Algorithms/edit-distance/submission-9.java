// class Solution {
//     public int minDistance(String word1, String word2) {
//         int m = word1.length(), n = word2.length();
//         int[][] dp = new int[m+1][n+1];
//         for (int i = 1; i < m+1; i++) {
//             dp[i][0] = i;
//         }

//         for (int j = 1; j < n+1; j++) {
//             dp[0][j] = j;
//         }

//         for (int i = 1; i < m+1; i++) {
//             for (int j = 1; j < n+1; j++) {
//                 if (word1.charAt(i-1) == word2.charAt(j-1)) {
//                     dp[i][j] = dp[i-1][j-1];
//                 } else {
//                     dp[i][j] = Math.min(Math.min(dp[i-1][j-1] + 1, dp[i-1][j]+1), dp[i][j-1]+1);
//                 }
//             }
//         }
//         return dp[m][n];
//     }
// }

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] prev = new int[n+1];
        for (int j = 0; j <= n; j++) {
            prev[j] = j;
        }

        for (int i = 1; i < m+1; i++) {
            int[] cur = new int[n+1];
            cur[0] = i;
            for (int j = 1; j < n+1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cur[j] = prev[j-1];
                } else {
                    cur[j] = Math.min(Math.min(prev[j-1]+1, prev[j]+1), cur[j-1]+1);
                }
            }
            prev = cur;
        }
        return prev[n];
    }
}
