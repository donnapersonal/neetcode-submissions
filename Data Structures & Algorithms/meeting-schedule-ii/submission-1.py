"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        if not intervals:
            return 0
        
        intervals.sort(key=lambda x: x.start)
        min_heap = []
        max_rooms = 0
        for interval in intervals:
            while min_heap and min_heap[0] <= interval.start:
                heapq.heappop(min_heap)
            
            heapq.heappush(min_heap, interval.end)
            max_rooms = max(max_rooms, len(min_heap))
        
        return max_rooms