class Solution {
    private List<List<Integer>> res;
    private List<Integer> track;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        track = new ArrayList<>();
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i+1);
            track.remove(track.size() - 1);
        }
    }
}
