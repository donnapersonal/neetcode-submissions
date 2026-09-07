# class Solution:
#     def maxProduct(self, nums: List[int]) -> int:
#         n = len(nums)
#         if n == 0:
#             return 0
        
#         maxNum, minNum = nums[0], nums[0]
#         res = nums[0]
#         for i in range(1, n):
#             cur = nums[i]
#             tempMax = max(cur, maxNum * cur, minNum * cur)
#             minNum = min(cur, maxNum * cur, minNum * cur)
#             maxNum = tempMax
#             res = max(res, maxNum)
        
#         return res

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0
        
        maxNum, minNum = nums[0], nums[0]
        res = nums[0]
        for i in range(1, n):
            cur = nums[i]
            tempMax = maxNum
            tempMin = minNum
            maxNum = max(cur, tempMax * cur, tempMin * cur)
            minNum = min(cur, tempMax * cur, tempMin * cur)
            res = max(res, maxNum)
        
        return res