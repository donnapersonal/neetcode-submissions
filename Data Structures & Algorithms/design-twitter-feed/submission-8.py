class Twitter:

    def __init__(self):
        # 全局时间戳
        self.globalTime = 0
        # 记录用户 ID 到用户示例的映射
        self.idToUser = {}
    
    # Tweet 类
    class Tweet:
        def __init__(self, id, timestamp):
            self.id = id
            # 新建一条 tweet 时记录并更新时间戳
            self.timestamp = timestamp
            # 指向下一条 tweet，类似单链表结构
            self.next = None
        
        def getId(self):
            return self.id

        def getTimestamp(self):
            return self.timestamp

        def getNext(self):
            return self.next

        def setNext(self, next):
            self.next = next
    
    # 用户类
    class User:
        def __init__(self, id):
            self.id = id
            self.tweetHead = None
            # 记录该用户的关注者
            self.followedUserSet = set()

        def getId(self):
            return self.id

        def getTweetHead(self):
            return self.tweetHead

        def getFollowedUserSet(self):
            return self.followedUserSet

        def __eq__(self, other):
            return self.id == other.id

        def __hash__(self):
            return hash(self.id)

        # 关注其他人
        def follow(self, other):
            self.followedUserSet.add(other.id)
        
        # 取关其他人
        def unfollow(self, other):
            self.followedUserSet.discard(other.id)

        # 发布一条 tweet
        def post(self, tweet):
            # 把新发布的 tweet 作为链表头节点
            tweet.setNext(self.tweetHead)
            self.tweetHead = tweet

    def postTweet(self, userId: int, tweetId: int) -> None:
        if userId not in self.idToUser:
            self.idToUser[userId] = self.User(userId)

        user = self.idToUser[userId]
        user.post(self.Tweet(tweetId, self.globalTime))
        self.globalTime += 1

    def getNewsFeed(self, userId: int) -> List[int]:
        res = []
        if userId not in self.idToUser:
            return res

        # 获取该用户关注的用户列表
        user = self.idToUser[userId]
        followedUserSet = user.getFollowedUserSet()
        # 每个用户的 tweet 是一条按时间排序的链表
        # 现在执行合并多条有序链表的逻辑，找出时间线中的最近 10 条动态
        pq = []
        # 该用户自己的 tweet 也在时间线内
        if user.getTweetHead() is not None:
            heapq.heappush(pq, (-user.getTweetHead().getTimestamp(), user.getTweetHead()))

        for otherId in followedUserSet:
            other = self.idToUser[otherId]
            if other.getTweetHead() is not None:
                heapq.heappush(pq, (-other.getTweetHead().getTimestamp(), other.getTweetHead()))

        # 合并多条有序链表
        count = 0
        while pq and count < 10:
            _, tweet = heapq.heappop(pq)
            res.append(tweet.getId())
            if tweet.getNext() is not None:
                heapq.heappush(pq, (-tweet.getNext().getTimestamp(), tweet.getNext()))
            count += 1

        return res

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId == followeeId:
            return
        # 如果用户还不存在，则新建用户
        if followerId not in self.idToUser:
            self.idToUser[followerId] = self.User(followerId)
        if followeeId not in self.idToUser:
            self.idToUser[followeeId] = self.User(followeeId)

        follower = self.idToUser[followerId]
        followee = self.idToUser[followeeId]
        # 关注者关注被关注者
        follower.follow(followee)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId == followeeId:
            return
        if followerId not in self.idToUser or followeeId not in self.idToUser:
            return

        follower = self.idToUser[followerId]
        followee = self.idToUser[followeeId]
        # 关注者取关被关注者
        follower.unfollow(followee)