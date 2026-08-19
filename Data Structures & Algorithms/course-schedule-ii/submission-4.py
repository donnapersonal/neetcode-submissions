class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = defaultdict(list)
        indegree = [0] * numCourses
        for course, pre in prerequisites:
            graph[pre].append(course)
            indegree[course] += 1
        res = []
        que = deque([i for i in range(numCourses) if indegree[i] == 0]);
        while que:
            course = que.popleft()
            res.append(course)
            for nxt in graph[course]:
                indegree[nxt] -= 1
                if indegree[nxt] == 0:
                    que.append(nxt)
        
        return res if len(res) == numCourses else [];