class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res, track = [], []
        def backtrack(nums):
            if len(track) == len(nums):
                res.append(track[:])
                return
            
            for i in range(len(nums)):
                if nums[i] in track:
                    continue
                
                track.append(nums[i])
                backtrack(nums)
                track.pop()
                
        backtrack(nums)
        return res