class Solution:
    def partition(self, s: str) -> List[List[str]]:
        n = len(s)
        res = []
        track = []
        def dfs(start):
            if start == n:
                res.append(track[:])
                return
            
            for i in range(start, n):
                if not self.isPalindrome(s, start, i):
                    continue
                
                track.append(s[start:i+1])
                dfs(i+1)
                track.pop()

        dfs(0)
        return res
    
    def isPalindrome(self, s, l, r):
        while l < r:
            if s[l] != s[r]:
                return False
            
            l += 1
            r -= 1
        
        return True