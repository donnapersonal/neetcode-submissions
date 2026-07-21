class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for ch in s:
            if ch == "(":
                stack.append(")")
            elif ch == "[":
                stack.append("]")
            elif ch == "{":
                stack.append("}")
            elif not len(stack) or stack[-1] != ch:
                return False
            else:
                stack.pop()
        
        return len(stack) == 0