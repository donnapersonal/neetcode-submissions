# class Solution:
#     def wordBreak(self, s: str, wordDict: List[str]) -> bool:
#         self.memo = [-1] * len(s)

#         return self.dp(s, wordDict, 0)

#     def dp(self, s, wordDict, i):
#         # Successfully matched the entire string.
#         if i == len(s):
#             return True

#         # Return cached result.
#         if self.memo[i] != -1:
#             return self.memo[i] == 1

#         # Try every word as a prefix of s[i:].
#         for word in wordDict:
#             length = len(word)

#             # Prevent going out of bounds.
#             if i + length > len(s):
#                 continue

#             # Check whether the current prefix matches the word.
#             subStr = s[i:i + length]

#             if subStr != word:
#                 continue

#             # Recursively check the remaining suffix.
#             if self.dp(s, wordDict, i + length):
#                 self.memo[i] = 1
#                 return True

#         # No word can successfully split s[i:].
#         self.memo[i] = 0
#         return False

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict)
        n = len(s)
        dp = [False] * (n+1)
        dp[0] = True
        for i in range(1, n+1):
            for j in range(i):
                if dp[j] and s[j:i] in wordSet:
                    dp[i] = True
                    break
            
        return dp[n]