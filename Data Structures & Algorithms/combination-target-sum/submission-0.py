class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        self.res, self.track = [], []
        nums.sort()
        self.backtrack(nums, target, 0)
        return self.res
    
    def backtrack(self, nums, target, start):
        if target == 0:
            self.res.append(self.track.copy())
            return
        
        for i in range(start, len(nums)):
            cur = nums[i]
            if cur > target:
                break
            
            self.track.append(cur)
            self.backtrack(nums, target - cur, i)
            self.track.pop()