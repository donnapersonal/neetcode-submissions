# class Solution:
#     def coinChange(self, coins: List[int], amount: int) -> int:
#         if amount == 0:
#             return 0
        
#         visied = set([amount])
#         que = collections.deque([amount])
#         step = 0
#         while que:
#             step += 1
#             size = len(que)
#             for _ in range(size):
#                 cur = que.popleft()
#                 for coin in coins:
#                     if cur == coin:
#                         return step
                    
#                     if cur > coin and cur - coin not in visied:
#                         visied.add(cur - coin)
#                         que.append(cur - coin)
        
#         return -1

# class Solution:
#     def coinChange(self, coins: List[int], amount: int) -> int:
#         if amount == 0:
#             return 0
        
#         dp = [float('inf')] * (amount + 1)
#         dp[0] = 0
#         for coin in coins:
#             for i in range(coin, amount+1):
#                 dp[i] = min(dp[i], dp[i-coin]+1)
        
#         return dp[amount] if dp[amount] != float('inf') else -1

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0
        for i in range(1, amount+1):
            for coin in coins:
                if i - coin >= 0:
                    dp[i] = min(dp[i], dp[i-coin]+1)
                    
        return dp[amount] if dp[amount] != float('inf') else -1
        