class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int curEnd = 0;
        int maxPos = 0;
        for (int i = 0; i < n-1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = maxPos;
                if (curEnd >= n - 1) break;
            }
        }
        return jumps;
    }
}
