"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

# class Solution:
#     def minMeetingRooms(self, intervals: List[Interval]) -> int:
#         if not intervals:
#             return 0
        
#         intervals.sort(key=lambda x: x.start)
#         min_heap = []
#         max_rooms = 0
#         for interval in intervals:
#             while min_heap and min_heap[0] <= interval.start:
#                 heapq.heappop(min_heap)
            
#             heapq.heappush(min_heap, interval.end)
#             max_rooms = max(max_rooms, len(min_heap))
        
#         return max_rooms

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        if not intervals:
            return 0
        
        # Extracts all start times and end times from the meetings.
        # Sorts them separately.
        # Why? So we can simulate a timeline to track how many meetings are overlapping at any given time.
        starts = sorted(i.start for i in intervals)
        ends = sorted(i.end for i in intervals)
        # start pointer iterates over the starts array.
        # end pointer tracks the earliest end time.
        start, end = 0, 0
        # rooms keeps track of the number of rooms in use at that moment.
        rooms = 0

        # I loop through all meeting start times.
        while start < len(intervals):
            # If the current meeting starts before the earliest ending meeting has finished, we need a new room.
            # So, increment the rooms counter.
            if starts[start] < ends[end]:
                rooms += 1
            else:
                # If the current meeting starts after or exactly when another meeting ends, it means we can reuse a room.
                # So we move the end pointer forward (i.e., one room becomes free).
                end += 1
            
            # Advance the start pointer to check the next meeting.
            start += 1
        
        # Return the maximum number of rooms needed at any point in time.
        return rooms