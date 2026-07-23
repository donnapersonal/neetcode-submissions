# class Solution:
#     def lengthOfLongestSubstring(self, s: str) -> int:
#         left, right = 0, 0
#         res = 0
#         window = {}
#         while right < len(s):
#             c = s[right]
#             right += 1
#             if c in window:
#                 window[c] += 1
#             else:
#                 window[c] = 1
            
#             while window[c] > 1:
#                 d = s[left]
#                 left += 1
#                 window[d] -= 1
            
#             res = max(res, right - left)
        
#         return res

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        need = set()
        left = 0
        res = 0
        for right in range(len(s)):
            while s[right] in need:
                need.remove(s[left])
                left += 1
            
            need.add(s[right])
            res = max(res, right - left + 1)
        
        return res