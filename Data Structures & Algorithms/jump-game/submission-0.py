class Solution:
    def canJump(self, nums: List[int]) -> bool:
        maxReachable = 0
        n = len(nums)
        for i in range(n):
            if i > maxReachable:
                return False
            
            maxReachable = max(maxReachable, i + nums[i])
            if maxReachable >= n - 1:
                return True
        
        return True