class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        res = []
        lastIdx = {ch:i for i, ch in enumerate(s)}
        start, end = 0, 0
        for i in range(len(s)):
            end = max(end, lastIdx[s[i]])
            if end == i:
                res.append(end - start + 1);
                start = i + 1
        
        return res

