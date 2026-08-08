# class Solution:
#     def permute(self, nums: List[int]) -> List[List[int]]:
#         res, track = [], []
#         def backtrack(nums):
#             if len(track) == len(nums):
#                 res.append(track[:])
#                 return
            
#             for i in range(len(nums)):
#                 if nums[i] in track:
#                     continue
                
#                 track.append(nums[i])
#                 backtrack(nums)
#                 track.pop()

#         backtrack(nums)
#         return res

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        res, track = [], []
        used = [False] * n
        def backtrack(nums):
            if len(track) == n:
                res.append(track[:])
                return
            
            for i in range(n):
                if used[i]:
                    continue
                
                track.append(nums[i])
                used[i] = True
                backtrack(nums)
                used[i] = False
                track.pop()
                
        backtrack(nums)
        return res