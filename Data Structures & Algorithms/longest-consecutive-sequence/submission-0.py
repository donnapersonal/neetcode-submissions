class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)
        n = len(num_set)
        res = 0
        for num in nums:
            if num - 1 in num_set:
                continue
            
            next_num = num + 1
            while next_num in num_set:
                next_num += 1
            
            res = max(res, next_num - num)
            if res * 2 >= n:
                break
            
        return res