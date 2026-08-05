class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = []
        n = len(intervals)
        curIdx = 0
        while curIdx < n and intervals[curIdx][1] < newInterval[0]:
            res.append(intervals[curIdx])
            curIdx += 1
        
        while curIdx < n and intervals[curIdx][0] <= newInterval[1]:
            newInterval[0] = min(intervals[curIdx][0], newInterval[0])
            newInterval[1] = max(intervals[curIdx][1], newInterval[1])
            curIdx += 1
        
        res.append(newInterval)
        while curIdx < n:
            res.append(intervals[curIdx])
            curIdx += 1
        
        return res