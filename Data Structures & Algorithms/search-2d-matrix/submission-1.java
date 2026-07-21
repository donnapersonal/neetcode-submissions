class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int i = mid / n;
            int j = mid % n;
            int value = matrix[i][j];
            if (value == target) {
                return true;
            } else if (value < target) {
                left++;
            } else if (value > target) {
                right--;
            }
        }
        return false;
    }
}
