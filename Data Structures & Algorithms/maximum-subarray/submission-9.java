// class Solution {
//     public int maxSubArray(int[] nums) {
//         int res = Integer.MIN_VALUE;
//         int minPreSum = 0;
//         int preSum = 0;
//         for (int num : nums) {
//             preSum += num;
//             res = Math.max(res, preSum - minPreSum);
//             minPreSum = Math.min(minPreSum, preSum);
//         }
//         return res;
//     }
// }

class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            res = Math.max(res, curSum);
        }
        return res;
    }
}
