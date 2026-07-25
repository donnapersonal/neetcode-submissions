class LRUCache:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.cache = collections.OrderedDict()

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        
        self.makeRecent(key)
        return self.cache[key]

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.cache[key] = value
            self.makeRecent(key)
            return
        
        if len(self.cache) >= self.cap:
            oldestkey = next(iter(self.cache))
            self.cache.pop(oldestkey)
        
        self.cache[key] = value
    
    def makeRecent(self, key):
        value = self.cache.pop(key)
        self.cache[key] = value
