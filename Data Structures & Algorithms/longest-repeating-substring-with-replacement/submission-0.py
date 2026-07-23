class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        left, right = 0, 0
        freq = [0] * 26
        maxFreq = 0
        res = 0
        while right < len(s):
            c = ord(s[right]) - ord('A')
            freq[c] += 1
            maxFreq = max(maxFreq, freq[c])
            right += 1

            if right - left > maxFreq + k:
                d = ord(s[left]) - ord('A')
                freq[d] -= 1
                left += 1
            
            res = max(res, right - left)
        
        return res