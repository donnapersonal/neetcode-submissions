class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        if not len(heights) or not len(heights[0]):
            return []
        
        m, n = len(heights), len(heights[0])
        # pacific 和 atlantic 用来分别标记哪些点可以流到对应的海洋
        # 最终交集中即为能流向两边的点
        pacific = [[False] * n for _ in range(m)]
        atlantic = [[False] * n for _ in range(m)]
        res = []
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        # r, c：当前单元格的行号和列号
        # ocean：要更新的目标海洋（pacific 或 atlantic）
        # prevHeight：上一单元格的高度，用于判断水是否能够从当前单元格流向相邻单元格
        def dfs(r, c, ocean, prevHeight):
            # r < 0 or c < 0 or r >= m or c >= n：当前单元格超出矩阵边界时，直接返回
            # ocean[r][c]：如果当前单元格已被标记为可流向海洋，也直接返回，避免重复访问
            # heights[r][c] < prevHeight：如果当前单元格的高度小于上一单元格的高度，水不能从前一个单元格流到当前单元格，直接返回
            if r < 0 or c < 0 or r >= m or c >= n or ocean[r][c] or heights[r][c] < prevHeight:
                return
            
            # 通过 ocean[r][c] = True 标记当前单元格为可流向目标海洋
            ocean[r][c] = True
            # 用 dirs 数组表示四个方向（上、下、左、右），分别递归调用 dfs，探索相邻的四个单元格
            for dr, dc in dirs:
                dfs(r + dr, c + dc, ocean, heights[r][c])
                
        for r in range(m):
            # 左边界流向太平洋
            dfs(r, 0, pacific, heights[r][0])
            # 右边界流向大西洋
            dfs(r, n-1, atlantic, heights[r][n-1])
        
        for c in range(n):
            # 上边界流向太平洋
            dfs(0, c,  pacific, heights[0][c])
            # 下边界流向大西洋
            dfs(m-1, c, atlantic, heights[m-1][c])
        
        for r in range(m):
            for c in range(n):
                # 如果一个单元格在 pacific 和 atlantic 两个矩阵中都被标记为 True，将该单元格的坐标加入结果 res 中
                if pacific[r][c] and atlantic[r][c]:
                    res.append([r, c])
        
        return res