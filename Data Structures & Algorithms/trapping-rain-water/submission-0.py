class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height);
        if n == 0:
            return 0
        
        total = 0
        stack = []
        stack.append(0)
        for i in range(1, n):
            while stack and height[i] > height[stack[-1]]:
                min_height = stack.pop()
                if stack:
                    h = min(height[i], height[stack[-1]]) - height[min_height]
                    w = i - stack[-1] - 1
                    total += h * w
        
            stack.append(i)
        
        return total