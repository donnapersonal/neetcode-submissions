# class Solution:
#     def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
#         graph = defaultdict(list)
#         indegree = [0] * numCourses
#         for course, pre in prerequisites:
#             graph[pre].append(course)
#             indegree[course] += 1
#         res = []
#         que = deque([i for i in range(numCourses) if indegree[i] == 0]);
#         while que:
#             course = que.popleft()
#             res.append(course)
#             for nxt in graph[course]:
#                 indegree[nxt] -= 1
#                 if indegree[nxt] == 0:
#                     que.append(nxt)
        
#         return res if len(res) == numCourses else [];

class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = defaultdict(list)
        for course, pre in prerequisites:
           graph[course].append(pre)

        res = []
        visited = [0] * numCourses
        def dfs(course):
            if visited[course] == 1:
                return False
            
            if visited[course] == 2:
                return True
            
            visited[course] = 1
            for pre in graph[course]:
                if not dfs(pre):
                    return False
                
            visited[course] = 2
            res.append(course)
            return True

        for i in range(numCourses):
            if not dfs(i):
                return []

        return res