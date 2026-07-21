# class Solution:
#     def trap(self, height: List[int]) -> int:
#         n = len(height);
#         if n == 0:
#             return 0
        
#         total = 0
#         stack = []
#         stack.append(0)
#         for i in range(1, n):
#             while stack and height[i] > height[stack[-1]]:
#                 min_height = stack.pop()
#                 if stack:
#                     h = min(height[i], height[stack[-1]]) - height[min_height]
#                     w = i - stack[-1] - 1
#                     total += h * w
        
#             stack.append(i)
        
#         return total

class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height);
        if n == 0:
            return 0
        
        left, right = 0, n - 1
        l_max, r_max = 0, 0
        res = 0
        while left < right:
            l_max = max(l_max, height[left])
            r_max = max(r_max, height[right])
            if l_max < r_max:
                res += l_max - height[left]
                left += 1
            else:
                res += r_max - height[right]
                right -= 1
        
        return res