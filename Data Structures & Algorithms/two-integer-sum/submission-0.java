class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> newMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int diff = target - nums[i];
            if (newMap.containsKey(diff)) {
                return new int[]{newMap.get(diff), i};
            }
            newMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
