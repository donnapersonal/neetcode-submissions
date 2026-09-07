// class Solution {
//     public int numDecodings(String s) {
//         int n = s.length();
//         if (s == null || n == 0) {
//             return 0;
//         }

//         int[] dp = new int[n+1];
//         dp[0] = 1;
//         dp[1] = s.charAt(0) == '0' ? 0 : 1;
//         for (int i = 2; i < n+1; i++) {
//             if (s.charAt(i-1) != '0') {
//                 dp[i] += dp[i-1];
//             }

//             int twoDigit = (s.charAt(i-2) - '0') * 10 + (s.charAt(i-1) - '0');
//             if (twoDigit >= 10 && twoDigit <= 26) {
//                 dp[i] += dp[i-2];
//             }
//         }
//         return dp[n];
//     }
// }

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int prev = 1;
        int cur = 1;
        for (int i = 1; i < n; i++) {
            int temp = 0;
            if (s.charAt(i) != '0') {
                temp += cur;
            }

            int twoDigit = (s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                temp += prev;
            }

            prev = cur;
            cur = temp;
        }
        return cur;
    }
}
