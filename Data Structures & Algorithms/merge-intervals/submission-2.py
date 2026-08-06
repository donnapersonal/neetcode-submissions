# class Solution:
#     def merge(self, intervals: List[List[int]]) -> List[List[int]]:
#         res = []
#         intervals.sort(key=lambda x: x[0])
#         res.append(intervals[0])
#         for i in range(1, len(intervals)):  
#             cur = intervals[i]
#             last = res[-1]
#             if cur[0] <= last[1]:
#                 last[1] = max(cur[1], last[1])
#             else:
#                 res.append(cur)
        
#         return res

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        res = []
        intervals.sort(key=lambda x: x[0])
        
        for interval in intervals:
            if not res or res[-1][1] < interval[0]:
                res.append(interval)
            else:
                res[-1][1] = max(interval[1], res[-1][1])
        
        return res

