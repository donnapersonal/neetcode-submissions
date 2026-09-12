# class Solution:
#     def uniquePaths(self, m: int, n: int) -> int:
#         dp = [1] * n
#         for i in range(1, m):
#             for j in range(1, n):
#                 dp[j] += dp[j-1]
        
#         return dp[n-1]

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return self.combination(m+n-2, min(m-1, n-1))
    
    def combination(self, a, b):
        res = 1
        for i in range(1, b+1):
            res = res * (a - i + 1) // i
        
        return res