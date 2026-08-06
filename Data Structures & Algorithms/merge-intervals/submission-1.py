class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        res = []
        intervals.sort(key=lambda x: x[0])
        res.append(intervals[0])
        for i in range(1, len(intervals)):  
            cur = intervals[i]
            last = res[-1]
            if cur[0] <= last[1]:
                last[1] = max(cur[1], last[1])
            else:
                res.append(cur)
        
        return res

