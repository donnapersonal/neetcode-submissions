class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res, track = [], []
        nums.sort()
        def backtrack(nums, start):
            res.append(track[:])
            for i in range(start, len(nums)):
                if i > start and nums[i] == nums[i-1]:
                    continue
                
                track.append(nums[i])
                backtrack(nums, i+1)
                track.pop()

        backtrack(nums, 0)
        return res