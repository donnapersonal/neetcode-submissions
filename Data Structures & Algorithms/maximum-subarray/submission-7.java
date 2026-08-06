class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int minPreSum = 0;
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            res = Math.max(res, preSum - minPreSum);
            minPreSum = Math.min(minPreSum, preSum);
        }
        return res;
    }
}
