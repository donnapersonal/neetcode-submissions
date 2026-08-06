class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        res = float('-inf')
        min_pre_sum = pre_sum = 0
        for num in nums:
            pre_sum += num
            res = max(res, pre_sum - min_pre_sum)
            min_pre_sum = min(min_pre_sum, pre_sum)
        
        return res

