# class Solution:
#     def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
#         graph = [[] for _ in range(numCourses)]
#         for course, pre in prerequisites:
#             graph[course].append(pre)
        
#         visited = [0] * numCourses
#         def dfs(course):
#             if visited[course] == 1:
#                 return False
            
#             if visited[course] == 2:
#                 return True
            
#             visited[course] = 1
#             for pre in graph[course]:
#                 if not dfs(pre):
#                     return False
            
#             visited[course] = 2
#             return True

#         for course in range(numCourses):
#             if not dfs(course):
#                 return False
        
#         return True

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = [[] for _ in range(numCourses)]
        indegree = [0] * numCourses
        for course, pre in prerequisites:
            graph[pre].append(course)
            indegree[course] += 1
        
        que = deque()
        for course in range(numCourses):
            if indegree[course] == 0:
                que.append(course)

        processed = 0
        
        while que:
            course = que.popleft()
            processed += 1
            for nxt in graph[course]:
                indegree[nxt] -= 1
                if indegree[nxt] == 0:
                    que.append(nxt)
    
        return processed == numCourses
            