class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if ((total + target) % 2 != 0 || total < Math.abs(target)) {
            return 0;
        }

        int p = (total + target) / 2;
        int[] dp = new int[p+1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = p; i >= num; i--) {
                dp[i] += dp[i-num];
            }
        }
        return dp[p];
    }
}
