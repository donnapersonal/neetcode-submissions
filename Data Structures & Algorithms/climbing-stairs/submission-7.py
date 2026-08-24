# class Solution:
#     def climbStairs(self, n: int) -> int:
#         self.memo = [0] * (n+1);
#         return self.dp(n);
    
#     def dp(self, n):
#         if n <= 2:
#             return n
        
#         if self.memo[n] > 0:
#             return self.memo[n]
        
#         self.memo[n] = self.dp(n-1) + self.dp(n-2)
#         return self.memo[n]

class Solution:
    def climbStairs(self, n: int) -> int:
        dp = [0 for _ in range(n+1)]
        dp[0] = 1
        dp[1] = 1
        for i in range(2, n+1):
            dp[i] = dp[i-1] + dp[i-2]
        
        return dp[n]
