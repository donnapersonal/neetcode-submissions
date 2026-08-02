# class Solution:
#     def findKthLargest(self, nums: List[int], k: int) -> int:
#         pq = []
#         for num in nums:
#             heapq.heappush(pq, num)
#             if len(pq) > k:
#                 heapq.heappop(pq)
        
#         return pq[0]

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        n = len(nums)
        return self.quickSelect(nums, 0, n-1, n-k)

    def quickSelect(self, nums, l, r, k):
        if l == r:
            return nums[k]
        x = nums[l]
        i, j = l-1, r+1
        while i < j:
            while True:
                i += 1
                if nums[i] >= x:
                    break
            
            while True:
                j -= 1
                if nums[j] <= x:
                    break
                
            if i < j:
                nums[i], nums[j] = nums[j], nums[i]
        
        if k <= j:
            return self.quickSelect(nums, l, j, k)
        else:
            return self.quickSelect(nums, j+1, r, k)
    