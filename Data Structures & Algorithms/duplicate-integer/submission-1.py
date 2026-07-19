class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        numMap = {}
        for num in nums:
            if num in numMap:
                return True
            
            numMap[num] = num
        
        return False