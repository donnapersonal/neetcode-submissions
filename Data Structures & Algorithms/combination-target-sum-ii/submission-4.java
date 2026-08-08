class Solution {
    private List<List<Integer>> res;
    private List<Integer> track;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        track = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int cur = candidates[i];
            if (cur > target) break;
            if (i > start && cur == candidates[i-1]) continue;
            track.add(cur);
            backtrack(candidates, target - cur, i + 1);
            track.remove(track.size() - 1);
        }
    }
}
