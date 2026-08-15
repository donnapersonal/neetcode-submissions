# class Solution:
#     def letterCombinations(self, digits: str) -> List[str]:
#         MAP = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
#         if not digits:
#             return []
        
#         res, path = [], []
#         n = len(digits)

#         def backtrack(index):
#             if len(path) == n:
#                 res.append("".join(path))
#                 return
            
#             digit = ord(digits[index]) - ord('0')
#             for c in MAP[digit]:
#                 path.append(c)
#                 backtrack(index+1)
#                 path.pop()

#         backtrack(0)
#         return res

# class Solution:
#     def letterCombinations(self, digits: str) -> List[str]:
#         MAP = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
#         if not digits:
#             return []
        
#         res = []
#         n = len(digits)

#         def backtrack(index, s):
#             if index == n:
#                 res.append(s)
#                 return
            
#             digit = ord(digits[index]) - ord('0')
#             letters = MAP[digit]
#             for letter in letters:
#                 backtrack(index+1, s+letter)

#         backtrack(0, "")
#         return res

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        MAP = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
        n = len(digits)
        if n == 0:
            return []
        
        res = []
        path = [""] * n
    
        def backtrack(index):
            if index == n:
                res.append("".join(path))
                return
            
            digit = ord(digits[index]) - ord('0')
            letters = MAP[digit]
            for letter in letters:
                path[index] = letter
                backtrack(index+1)

        backtrack(0)
        return res