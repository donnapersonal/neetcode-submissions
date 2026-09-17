class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m, n = len(s), len(p)
        dp = [[False] * (n+1) for _ in range(m+1)]
        dp[0][0] = True

        def matches(i, j):
            if i == 0:
                return False
            
            if p[j-1] == ".":
                return True
            
            return s[i-1] == p[j-1]

        for i in range(m+1):
            for j in range(1, n+1):
                if p[j-1] == "*":
                    dp[i][j] |= dp[i][j-2]

                    if matches(i, j-1):
                        dp[i][j] |= dp[i-1][j]
                else:
                    if matches(i, j):
                        dp[i][j] |= dp[i-1][j-1]
        
        return dp[m][n]