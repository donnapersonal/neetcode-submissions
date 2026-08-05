# class Solution:
#     def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
#         res = []
#         n = len(intervals)
#         curIdx = 0
#         while curIdx < n and intervals[curIdx][1] < newInterval[0]:
#             res.append(intervals[curIdx])
#             curIdx += 1
        
#         while curIdx < n and intervals[curIdx][0] <= newInterval[1]:
#             newInterval[0] = min(intervals[curIdx][0], newInterval[0])
#             newInterval[1] = max(intervals[curIdx][1], newInterval[1])
#             curIdx += 1
        
#         res.append(newInterval)
#         while curIdx < n:
#             res.append(intervals[curIdx])
#             curIdx += 1
        
#         return res

class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = list()
        left, right = newInterval
        placed = False
        for l, r in intervals:
            if l > right:
                if not placed:
                    res.append([left, right])
                    placed = True
                res.append([l, r])
            elif r < left:
                res.append([l, r])
            else:
                left = min(left, l)
                right = max(right, r)
        
        if not placed:
            res.append([left, right])
        
        return res