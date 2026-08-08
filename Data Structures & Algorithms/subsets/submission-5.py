# class Solution:
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         self.res, self.track = [], []
#         self.backtrack(nums, 0)
#         return self.res
    
#     def backtrack(self, nums, start):
#         self.res.append(self.track[:])
#         n = len(nums)
#         if start > n:
#             return
        
#         for i in range(start, n):
#             self.track.append(nums[i])
#             self.backtrack(nums, i + 1)
#             self.track.pop()

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        res, track = [], []
        def backtrack(i: int) -> None:
            if i == n:
                res.append(track[:])
                return
            
            backtrack(i+1)

            track.append(nums[i])
            backtrack(i+1)
            track.pop()

        backtrack(0) 
        return res
        