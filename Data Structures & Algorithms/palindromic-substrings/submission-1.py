class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)
        total = 0
        def expandCenter(l, r):
            count = 0
            while l >= 0 and r < n and s[l] == s[r]:
                count += 1
                l -= 1
                r += 1
            return count
        
        for i in range(n):
            total += expandCenter(i, i)
            total += expandCenter(i, i+1)
        
        return total