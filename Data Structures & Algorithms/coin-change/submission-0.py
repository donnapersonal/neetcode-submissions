class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        
        visied = set([amount])
        que = collections.deque([amount])
        step = 0
        while que:
            step += 1
            size = len(que)
            for _ in range(size):
                cur = que.popleft()
                for coin in coins:
                    if cur == coin:
                        return step
                    
                    if cur > coin and cur - coin not in visied:
                        visied.add(cur - coin)
                        que.append(cur - coin)
        
        return -1