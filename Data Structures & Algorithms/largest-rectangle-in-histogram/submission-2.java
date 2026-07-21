class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] arr = new int[n+2];
        for (int i = 0; i < n; i++) {
            arr[i+1] = heights[i];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            while (arr[i] < arr[stack.peek()]) {
                int midHeight = arr[stack.pop()];
                int width = i - stack.peek() - 1;
                int area = midHeight * width;
                res = Math.max(res, area);
            }

            stack.push(i);
        }

        return res;
    }
}
