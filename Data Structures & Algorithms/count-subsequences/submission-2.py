# class Solution:
#     def numDistinct(self, s: str, t: str) -> int:
#         m, n = len(s), len(t)
#         dp = [[0] * (n + 1) for _ in range(m + 1)]

#         for i in range(m + 1):
#             dp[i][0] = 1  # 空串 t 的匹配方式始终是 1
        
#         for i in range(1, m + 1):
#             for j in range(1, n + 1):
#                 if s[i - 1] == t[j - 1]:
#                     dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
#                 else:
#                     dp[i][j] = dp[i - 1][j]
        
#         # 从 s[0..m-1] 中匹配出完整的 t[0..n-1]，总共有多少种方式
#         return dp[m][n]

# class Solution:
#     def numDistinct(self, s: str, t: str) -> int:
#         m, n = len(s), len(t)
#         if m < n:
#             return 0
        
#         dp = [[0] * (n + 1) for _ in range(m + 1)]
#         for i in range(m + 1):
#             dp[i][n] = 1
        
#         for i in range(m - 1, -1, -1):
#             for j in range(n - 1, -1, -1):
#                 if s[i] == t[j]:
#                     dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j]
#                 else:
#                     dp[i][j] = dp[i + 1][j]
        
#         return dp[0][0]

class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        m, n = len(s), len(t)
        if m < n:
            return 0
        
        dp = [0] * (n+1)
        dp[0] = 1
        
        for i in range(1, m+1):
            for j in range(n, 0, -1):
                if s[i-1] == t[j-1]:
                    dp[j] += dp[j - 1]
        
        return dp[n]

        # int m = s.length(), n = t.length();
        # dp = [[0] * (n+1) for _ in range(m+1)]
        # for (int i = 0; i < m+1; i++) {
        #     dp[i][0] = 1;
        # }
        # for (int i = 1; i < m+1; i++) {
        #     for (int j = 1; j < n+1; j++) {
        #         if (s.charAt(i-1) == t.charAt(j-1)) {
        #             dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
        #         } else {
        #             dp[i][j] = dp[i-1][j];
        #         }
        #     }
        # }
            
        
