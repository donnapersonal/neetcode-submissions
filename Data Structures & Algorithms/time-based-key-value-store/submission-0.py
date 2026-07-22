# class TimeMap:

#     def __init__(self):
#         self.map = defaultdict(list)

#     def set(self, key: str, value: str, timestamp: int) -> None:
#         self.map[key].append((timestamp, value))

#     def get(self, key: str, timestamp: int) -> str:
#         if key not in self.map:
#             return ""
        
#         values = self.map[key]
#         i = bisect.bisect_right(key, (timestamp, chr(127)))
#         return values[i-1][1] if i > 0 else ""

class TimeMap:

    def __init__(self):
        self.map = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.map:
            self.map[key] = []
        
        self.map[key].append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.map:
            return ""
        
        values = self.map[key]
        left, right = 0, len(values) - 1
        res = ""
        while left <= right:
            mid = left + (right - left) // 2
            if values[mid][0] <= timestamp:
                res = values[mid][1]
                left = mid + 1
            else:
                right = mid - 1
            
        return res