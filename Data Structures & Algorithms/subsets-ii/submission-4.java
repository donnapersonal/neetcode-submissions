class Solution {
    private List<List<Integer>> res;
    private List<Integer> track;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        track = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, i+1);
            track.remove(track.size() - 1);
        }
    }
}
