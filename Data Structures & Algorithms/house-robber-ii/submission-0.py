class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        
        def robRange(start, end):
            prev2, prev1 = 0, 0
            for i in range(start, end+1):
                cur = max(prev2 + nums[i], prev1)
                prev2, prev1 = prev1, cur
            
            return prev1
        
        return max(robRange(0, n-2), robRange(1, n-1))