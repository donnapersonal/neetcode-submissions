# class Solution:
#     def lengthOfLIS(self, nums: List[int]) -> int:
#         n = len(nums)
#         dp = [1] * n
#         for i in range(n):
#             for j in range(i):
#                 if nums[i] > nums[j]:
#                     dp[i] = max(dp[i], dp[j] + 1)
        
#         res = 0
#         for i in range(len(dp)):
#             res = max(res, dp[i])
        
#         return res

# class Solution:
#     def lengthOfLIS(self, nums: List[int]) -> int:
#         n = len(nums)
#         dp = [1] * n
#         res = 1
#         for i in range(1, len(dp)):
#             for j in range(i):
#                 if nums[i] > nums[j]:
#                     dp[i] = max(dp[i], dp[j] + 1)
                
#                 res = max(res, dp[i])

#         return res

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        res = []
        for n in nums:
            if not res or n > res[-1]:
                res.append(n)
            else:
                l, r = 0, len(res) - 1
                loc = r
                while l <= r:
                    mid = (l+r) // 2
                    if res[mid] >= n:
                        loc = mid
                        r = mid - 1
                    else:
                        l = mid + 1
                
                res[loc] = n
        
        return len(res)
