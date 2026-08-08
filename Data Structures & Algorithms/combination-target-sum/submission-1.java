class Solution {
    private List<List<Integer>> res;
    private List<Integer> track;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        track = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, target, 0);
        return res;
    }

    private void backtrack(int[] nums, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            int cur = nums[i];
            if (cur > target) break;
            track.add(cur);
            backtrack(nums, target - cur, i);
            track.remove(track.size() - 1);
        }
    }
}
