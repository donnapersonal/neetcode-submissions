class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res, self.track = [], []
        self.backtrack(nums, 0)
        return self.res
    
    def backtrack(self, nums, start):
        self.res.append(self.track[:])
        n = len(nums)
        if start > n:
            return
        
        for i in range(start, n):
            self.track.append(nums[i])
            self.backtrack(nums, i + 1)
            self.track.pop()
        