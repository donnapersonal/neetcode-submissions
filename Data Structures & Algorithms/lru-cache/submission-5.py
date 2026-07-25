# class LRUCache:

#     def __init__(self, capacity: int):
#         self.cap = capacity
#         self.cache = collections.OrderedDict()

#     def get(self, key: int) -> int:
#         if key not in self.cache:
#             return -1
        
#         self.makeRecent(key)
#         return self.cache[key]

#     def put(self, key: int, value: int) -> None:
#         if key in self.cache:
#             self.cache[key] = value
#             self.makeRecent(key)
#             return
        
#         if len(self.cache) >= self.cap:
#             oldestkey = next(iter(self.cache))
#             self.cache.pop(oldestkey)
        
#         self.cache[key] = value
    
#     def makeRecent(self, key):
#         value = self.cache.pop(key)
#         self.cache[key] = value

class DLinkedNode:
    def __init__(self, key=0, value=0):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class LRUCache:

    def __init__(self, capacity: int):
        # 创建伪头节点 head 和伪尾节点 tail，方便统一插入和删除逻辑
        self.head = DLinkedNode()
        self.tail = DLinkedNode()
        # 初始状态：head <-> tail
        self.head.next = self.tail
        self.tail.prev = self.head

        # cache 是 key → node 的哈希映射
        self.cache = dict()
        # cap 是最大容量
        self.cap = capacity
        # size 记录当前元素数量
        self.size = 0

    def get(self, key: int) -> int:
        # 如果 key 不存在于缓存中，返回 -1
        if key not in self.cache:
            return -1
        
        # 若存在，则获取该节点
        node = self.cache[key]
        # 将其移动到链表头部（标记为最近使用）
        self.moveToHead(node)
        # 返回其值
        return node.value

    def put(self, key: int, value: int) -> None:
        # 如果 key 不存在，是插入新元素
        if key not in self.cache:
            # 创建新节点
            node = DLinkedNode(key, value)
            # 哈希表记录
            self.cache[key] = node
            # 加入到头部
            self.addToHead(node)
            # size +1
            self.size += 1
            # 如果超出容量：
            # 移除尾部节点（最久未使用）
            # 从哈希表中删除
            # size -1
            if self.size > self.cap:
                removed = self.removeTail()
                self.cache.pop(removed.key)
                self.size -= 1
        else:
            # 如果 key 存在：
            # 更新节点值
            # 移动到链表头（标记为最近使用）
            node = self.cache[key]
            node.value = value
            self.moveToHead(node)
    
    def addToHead(self, node):
        node.prev = self.head
        node.next = self.head.next
        self.head.next.prev = node
        self.head.next = node
    
    def removeNode(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev

    def moveToHead(self, node):
        self.removeNode(node)
        self.addToHead(node)
    
    def removeTail(self):
        node = self.tail.prev
        self.removeNode(node)
        return node
        