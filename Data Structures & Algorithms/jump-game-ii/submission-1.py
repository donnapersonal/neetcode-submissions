# class Solution:
#     def jump(self, nums: List[int]) -> int:
#         n = len(nums)
#         jumps = 0
#         cur_end = 0
#         max_pos = 0
#         for i in range(n-1):
#             max_pos = max(max_pos, i + nums[i])
#             if i == cur_end:
#                 jumps += 1
#                 cur_end = max_pos

#                 if cur_end >= n-1:
#                     break
        
#         return jumps

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [float("inf") for _ in range(n)]
        dp[0] = 0
        j = 0
        for i in range(1, n):
            while j + nums[j] < i:
                j += 1
            
            dp[i] = dp[j] + 1
        
        return dp[n-1]