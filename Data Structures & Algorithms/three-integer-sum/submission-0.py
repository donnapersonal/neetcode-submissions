# class Solution:
#     def threeSum(self, nums: List[int]) -> List[List[int]]:
#         n = len(nums)
#         res = []
#         nums.sort()
#         for i in range(n):
#             if nums[i] > 0:
#                 break
            
#             if i > 0 and nums[i] == nums[i-1]:
#                 continue
            
#             new = {}
#             for j in range(i+1, n):
#                 if j > i+2 and nums[j] == nums[j-1] == nums[j-2]:
#                     continue
                
#                 diff = 0 - (nums[i] + nums[j])
#                 if diff in new:
#                     res.append([nums[i], nums[j], diff])
#                     new.pop(diff)
#                 else:
#                     new[nums[j]] = j
        
#         return res

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        res = []
        nums.sort()
        for i in range(n):
            if nums[i] > 0:
                return res
            
            if i > 0 and nums[i] == nums[i-1]:
                continue
            
            left, right = i+1, n-1
            while left < right:
                total = nums[i] + nums[left] + nums[right]
                if total > 0:
                    right -= 1
                elif total < 0:
                    left += 1
                else:
                    res.append([nums[i], nums[left], nums[right]])
                    while left < right and nums[left] == nums[left+1]:
                        left += 1
                    
                    while left < right and nums[right] == nums[right-1]:
                        right -= 1
                    
                    left += 1
                    right -= 1
        
        return res
