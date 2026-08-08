class Solution {
    private List<List<Integer>> res;
    private List<Integer> track;
    private boolean[] used;
    private int n;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        res = new ArrayList<>();
        track = new ArrayList<>();
        used = new boolean[n];
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        if (track.size() == n) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums);
            used[i] = false;
            track.remove(track.size() - 1);
        }
    }
}
