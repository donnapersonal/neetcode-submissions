# class Solution:
#     def isValid(self, s: str) -> bool:
#         stack = []
#         for ch in s:
#             if ch == "(":
#                 stack.append(")")
#             elif ch == "[":
#                 stack.append("]")
#             elif ch == "{":
#                 stack.append("}")
#             elif not len(stack) or stack[-1] != ch:
#                 return False
#             else:
#                 stack.pop()
        
#         return len(stack) == 0

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        map = {
            "(": ")",
            "{": "}",
            "[": "]"
        }
        for ch in s:
            if ch in map:
                stack.append(ch)
                continue
            
            if not stack:
                return False
            
            if map[stack.pop()] != ch:
                return False
        
        return len(stack) == 0