# class Solution:
#     def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
#         n = len(nums)
#         que = deque()
#         res = []
#         for i in range(n):
#             if que and que[0] < i - k + 1:
#                 que.popleft()
            
#             while que and nums[que[-1]] < nums[i]:
#                 que.pop()
            
#             que.append(i)
#             if i >= k - 1:
#                 res.append(nums[que[0]])
        
#         return res


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        que = [(-nums[i], i) for i in range(k)]
        heapq.heapify(que)
        res = [-que[0][0]]

        for i in range(k, n):
            heapq.heappush(que, (-nums[i], i))
            while que[0][1] <= i - k:
                heapq.heappop(que)
            
            res.append(-que[0][0])
        
        return res