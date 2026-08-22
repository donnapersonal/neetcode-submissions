# class Solution:
#     def findItinerary(self, tickets: List[List[str]]) -> List[str]:
#         graph = defaultdict(deque)
#         path = []
#         for from_air, to_air in sorted(tickets):
#             graph[from_air].append(to_air)
        
#         def dfs(airport):
#             while graph[airport]:
#                 next_airport = graph[airport].popleft()
#                 dfs(next_airport)
            
#             path.append(airport)
        
#         dfs("JFK")
#         return path[::-1]

class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        graph = defaultdict(list)
        path = []
        for from_air, to_air in tickets:
            graph[from_air].append(to_air)
        
        for key in graph:
            heapq.heapify(graph[key])
        
        def dfs(airport):
            while graph[airport]:
                next_airport = heapq.heappop(graph[airport])
                dfs(next_airport)
            
            path.append(airport)
        
        dfs("JFK")
        return path[::-1]