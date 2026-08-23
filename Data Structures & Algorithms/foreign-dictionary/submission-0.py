class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        graph = defaultdict(list)
        indegree = {c : 0 for word in words for c in word}
        for i in range(len(words) - 1):
            first, second = words[i], words[i+1]
            min_len = min(len(first), len(second))
            if len(first) > len(second) and first[:min_len] == second[:min_len]:
                return ""
            
            for j in range(min_len):
                if first[j] != second[j]:
                    graph[first[j]].append(second[j])
                    indegree[second[j]] += 1
                    break
        
        que = deque([ch for ch in indegree if indegree[ch] == 0])
        res = []

        while que:
            ch = que.popleft()
            res.append(ch)
            for nei in graph[ch]:
                indegree[nei] -= 1
                if indegree[nei] == 0:
                    que.append(nei)
        
        if len(res) != len(indegree):
            return ""
        
        return "".join(res)
