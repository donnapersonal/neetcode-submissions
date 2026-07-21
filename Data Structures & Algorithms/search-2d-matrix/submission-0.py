class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False

        m, n = len(matrix), len(matrix[0])
        left, right = 0, m * n - 1
        while left <= right:
            mid = left + (right - left) // 2
            if self.get(matrix, mid) == target:
                return True
            elif self.get(matrix, mid) < target:
                left += 1
            elif self.get(matrix, mid) > target:
                right -= 1

        return False
    
    def get(self, matrix, index):
        n = len(matrix[0])
        i, j = index // n, index % n
        return matrix[i][j]
        