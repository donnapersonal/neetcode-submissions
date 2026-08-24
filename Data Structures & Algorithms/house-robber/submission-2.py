# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         n = len(nums)
#         if n == 0:
#             return 0
        
#         if n == 1:
#             return nums[0]
        
#         dp = [0] * n
#         dp[0] = nums[0]
#         dp[1] = max(nums[0], nums[1])
#         for i in range(2, n):
#             dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        
#         return dp[-1]


class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0
        
        if n == 1:
            return nums[0]
        
        prev2, prev1 = nums[0], max(nums[0], nums[1])
        for i in range(2, n):
            temp = max(prev1, prev2 + nums[i])
            prev2, prev1 = prev1, temp
        
        return prev1
