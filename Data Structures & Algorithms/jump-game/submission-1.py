# class Solution:
#     def canJump(self, nums: List[int]) -> bool:
#         maxReachable = 0
#         n = len(nums)
#         for i in range(n):
#             if i > maxReachable:
#                 return False
            
#             maxReachable = max(maxReachable, i + nums[i])
#             if maxReachable >= n - 1:
#                 return True
        
#         return True

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        dp = [0] * n
        dp[0] = nums[0]
        for i in range(1, n):
            if i <= dp[i-1]:
                dp[i] = max(dp[i-1], i + nums[i])
            else:
                dp[i] = dp[i-1]
        
        return dp[n-1] >= n-1