# class Solution:
#     def maxSubArray(self, nums: List[int]) -> int:
#         res = float('-inf')
#         min_pre_sum = pre_sum = 0
#         for num in nums:
#             pre_sum += num
#             res = max(res, pre_sum - min_pre_sum)
#             min_pre_sum = min(min_pre_sum, pre_sum)
        
#         return res

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        cur_sum = nums[0]
        max_sum = nums[0]
        for i in range(1, len(nums)):
            cur_sum = max(nums[i], cur_sum + nums[i])
            max_sum = max(cur_sum, max_sum)
        
        return max_sum

