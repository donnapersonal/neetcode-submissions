# class Solution:
#     def longestPalindrome(self, s: str) -> str:
#         res = ""
#         n = len(s)
#         for i in range(n):
#             s1 = self.expand(s, i, i)
#             s2 = self.expand(s, i, i+1)
#             res = res if len(res) > len(s1) else s1
#             res = res if len(res) > len(s2) else s2
        
#         return res
    
#     def expand(self, s, l, r):
#         while l >= 0 and r < len(s) and s[l] == s[r]:
#             l -= 1
#             r += 1
        
#         return s[l+1:r]

class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""
        
        start, end = 0, 0
        for i in range(len(s)):
            l1, r1 = self.expand(s, i, i)
            l2, r2 = self.expand(s, i, i+1)
            if r1 - l1 > end - start:
                start, end = l1, r1
            
            if r2 - l2 > end - start:
                start, end = l2, r2
        
        return s[start:end+1]
    
    def expand(self, s, l, r):
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
        
        return l+1, r-1

