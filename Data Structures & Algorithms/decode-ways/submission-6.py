# class Solution:
#     def numDecodings(self, s: str) -> int:
#         n = len(s)
#         if not s or n == 0:
#             return 0
        
#         dp = [0] * (n+1)
#         dp[0] = 1
#         dp[1] = 0 if s[0] == '0' else 1
#         for i in range(2, n+1):
#             if s[i-1] != '0':
#                 dp[i] += dp[i-1]
            
#             two_digit = int(s[i-2:i])
#             if 10 <= two_digit <= 26:
#                 dp[i] += dp[i-2]
        
#         return dp[n]

class Solution:
    def numDecodings(self, s: str) -> int:
        n = len(s)
        if not s or s[0] == '0':
            return 0
        
        prev, cur = 1, 1
        for i in range(1, n):
            temp = 0
            if s[i] != '0':
                temp += cur
            
            if '10' <= s[i-1:i+1] <= '26':
                temp += prev
            
            prev, cur = cur, temp
        
        return cur
