// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (nums[i] > nums[j]) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//             }
//         }
//         int res = 0;
//         for (int i = 0; i < dp.length; i++) {
//             res = Math.max(res, dp[i]);
//         }
//         return res;
//     }
// }

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);
//         int res = 1;
//         for (int i = 1; i < dp.length; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (nums[i] > nums[j]) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//                 res = Math.max(res, dp[i]);
//             }
//         }
//         return res;
//     }
// }

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int n : nums) {
            int l = 0, r = res.size() - 1;
            int loc = res.size();
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (res.get(mid) >= n) {
                    loc = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (loc == res.size()) {
                res.add(n);
            } else {
                res.set(loc, n);
            }
        }
        return res.size();
    }
}
