class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            if (res.isEmpty() || res.get(res.size() - 1)[1] < start) {
                res.add(new int[]{start, end});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], end);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
