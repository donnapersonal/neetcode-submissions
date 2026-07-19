# class Solution:
#     def isAnagram(self, s: str, t: str) -> bool:
#         slen = len(s)
#         tlen = len(t)
#         if slen != tlen:
#             return False
        
#         used = [False] * tlen
#         for ch in s:
#             found = False
#             for i in range(tlen):
#                 if not used[i] and t[i] == ch:
#                     used[i] = True
#                     found = True
#                     break
            
#             if not found:
#                 return False
        
#         return True

# class Solution:
#     def isAnagram(self, s: str, t: str) -> bool:
#         slen = len(s)
#         tlen = len(t)
#         if slen != tlen:
#             return False

#         count = [0] * 26
#         for ch in s:
#             count[ord(ch) - ord('a')] += 1
        
#         for ch in t:
#             if count[ord(ch) - ord('a')] == 0:
#                 return False
            
#             count[ord(ch) - ord('a')] -= 1
        
#         return True

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        slen = len(s)
        tlen = len(t)
        if slen != tlen:
            return False

        hashMap = {}
        for ch in s:
            if ch in hashMap:
                hashMap[ch] += 1
            else:
                hashMap[ch] = 1
        
        for ch in t:
            if ch not in hashMap:
                return False
            
            hashMap[ch] -= 1
            if hashMap[ch] < 0:
                return False
        
        return True
        