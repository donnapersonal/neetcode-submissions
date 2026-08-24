class Solution:
    def climbStairs(self, n: int) -> int:
        self.memo = [0] * (n+1);
        return self.dp(n);
    
    def dp(self, n):
        if n <= 2:
            return n
        
        if self.memo[n] > 0:
            return self.memo[n]
        
        self.memo[n] = self.dp(n-1) + self.dp(n-2)
        return self.memo[n]