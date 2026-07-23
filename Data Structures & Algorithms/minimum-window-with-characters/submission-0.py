class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t) > len(s):
            return ""
        
        left, right = 0, 0
        valid = 0
        need = Counter(t)
        window = Counter()
        start, min_len = 0, float('inf')
        
        while right < len(s):
            c = s[right]
            right += 1
            if c in need:
                window[c] += 1
                if window[c] == need[c]:
                    valid += 1
            
            while valid == len(need):
                if right - left < min_len:
                    start = left
                    min_len = right - left
                
                d = s[left]
                left += 1
                if d in need:
                    if window[d] == need[d]:
                        valid -= 1
                    
                    window[d] -= 1
        
        return "" if min_len == float('inf') else s[start:start + min_len]