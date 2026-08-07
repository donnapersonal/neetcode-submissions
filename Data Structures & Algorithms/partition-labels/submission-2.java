class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> lastIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            lastIdx.put(s.charAt(i), i);
        }

        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, lastIdx.get(s.charAt(i)));
            if (i == end) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
