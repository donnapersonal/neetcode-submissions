class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> valToFreq = new HashMap<>();
        for (int num : nums) {
            valToFreq.put(num, valToFreq.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freqToVals = new ArrayList[n+1];
        for (int i = 0; i < freqToVals.length; i++) {
            freqToVals[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : valToFreq.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            freqToVals[freq].add(num);
        }

        int[] res = new int[k];
        int idx = 0;
        for (int freq = freqToVals.length - 1; freq >= 1 && idx < k; freq--) {
            for (int num : freqToVals[freq]) {
                res[idx++] = num;
                if (idx == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
