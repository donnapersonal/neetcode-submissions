class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        prices = [float("inf")] * n
        prices[src] = 0

        for i in range(k+1):
            tmp = prices[:]
            for u, v, w in flights:
                if prices[u] != float("inf"):
                    tmp[v] = min(tmp[v], prices[u] + w)
            
            prices = tmp
        
        if prices[dst] == float("inf"):
            return -1
        
        return prices[dst]

        