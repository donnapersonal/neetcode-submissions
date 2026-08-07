# class Solution:
#     def checkValidString(self, s: str) -> bool:
#         low, high = 0, 0
#         for ch in s:
#             if ch == "(":
#                 low += 1
#                 high += 1
#             elif ch == ")":
#                 low -= 1
#                 high -= 1
#             else:
#                 low -= 1
#                 high += 1
            
#             if high < 0:
#                 return False
            
#             low = max(low, 0)
        
#         return low == 0

class Solution:
    def checkValidString(self, s: str) -> bool:
        left_stack, star_stack = [], []
        for i in range(len(s)):
            ch = s[i]
            if ch == "(":
                left_stack.append(i)
            elif ch == "*":
                star_stack.append(i)
            else:
                if left_stack:
                    left_stack.pop()
                elif star_stack:
                    star_stack.pop()
                else:
                    return False
        
        while left_stack and star_stack:
            left_idx = left_stack.pop()
            star_idx = star_stack.pop()
            if left_idx > star_idx:
                return False
        
        return len(left_stack) == 0
