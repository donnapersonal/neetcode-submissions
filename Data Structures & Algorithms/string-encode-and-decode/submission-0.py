class Solution:

    def encode(self, strs: List[str]) -> str:
        encoded_parts = []
        for value in strs:
            encoded_parts.append(str(len(value)))
            encoded_parts.append("#")
            encoded_parts.append(value)
        
        return "".join(encoded_parts)

    def decode(self, s: str) -> List[str]:
        decoded_str = []
        i = 0
        while i < len(s):
            j = i
            while s[j] != "#":
                j += 1
            
            length = int(s[i:j])
            start = j + 1
            end = start + length
            decoded_str.append(s[start:end])
            i = end
        
        return decoded_str
