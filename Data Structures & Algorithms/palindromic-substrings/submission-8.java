// class Solution {
//     private int n;
//     public int countSubstrings(String s) {
//         n = s.length();
//         int total = 0;
//         for (int i = 0; i < n; i ++) {
//             total += expandCenter(s, i, i);
//             total += expandCenter(s, i, i+1);
//         }
//         return total;
//     }

//     private int expandCenter(String s, int l, int r) {
//         int count = 0;
//         while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
//             count++;
//             l--;
//             r++;
//         }
//         return count;
//     }
// }

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
