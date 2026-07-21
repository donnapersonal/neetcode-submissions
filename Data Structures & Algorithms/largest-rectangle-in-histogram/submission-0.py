class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        heights.insert(0, 0)
        heights.append(0)
        stack = [0]
        max_area = 0
        for i in range(1, len(heights)):
            while stack and heights[i] < heights[stack[-1]]:
                min_height = heights[stack[-1]]
                stack.pop()
                if stack:
                    area = (i - stack[-1] - 1) * min_height
                    max_area = max(max_area, area)
            
            stack.append(i)
        
        return max_area
