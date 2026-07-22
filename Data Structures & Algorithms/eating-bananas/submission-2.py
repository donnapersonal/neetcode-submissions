class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left, right = 1, max(piles)
        while left < right:
            mid = left + (right - left) // 2
            if self.canFinish(piles, h, mid):
                right = mid
            else:
                left = mid + 1
        
        return left
    
    def canFinish(self, piles, h, k):
        hours = 0
        for pile in piles:
            # hours += ceil(pile / mid)
            hours += (pile + k - 1) // k
        
        if hours > h:
            return False
        
        return True