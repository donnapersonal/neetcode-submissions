class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int maxNum = nums[0];
        int minNum = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            int tempMax = maxNum;
            int tempMin = minNum;
            maxNum = Math.max(Math.max(cur, tempMax * cur), tempMin * cur);
            minNum = Math.min(Math.min(cur, tempMin * cur), tempMax * cur);
            res = Math.max(res, maxNum);
        }
        return res;
    }
}
