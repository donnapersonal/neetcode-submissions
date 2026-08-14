# class Solution:
#     def generateParenthesis(self, n: int) -> List[str]:
#         res = []
#         def dfs(s, left, right):
#             if len(s) == 2 * n:
#                 res.append(s)
#                 return
            
#             if left < n:
#                 dfs(s+ "(", left+1, right)
            
#             if right < left:
#                 dfs(s + ")", left, right+1)

#         dfs("", 0,0)
#         return res

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0:
            return []
        
        self.res, self.track = [], []
        self.backtrack(n, n)
        return self.res

    def backtrack(self, left, right):
        if right < left:
            return
        
        if left < 0 or right < 0:
            return
        
        if left == 0 and right == 0:
            self.res.append("".join(self.track))
            return
        
        self.track.append("(")
        self.backtrack(left - 1, right)
        self.track.pop()

        self.track.append(")")
        self.backtrack(left, right - 1)
        self.track.pop()

