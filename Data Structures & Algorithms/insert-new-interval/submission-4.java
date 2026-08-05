class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        int curIdx = 0;
        while (curIdx < n && intervals[curIdx][1] < newInterval[0]) {
            res.add(intervals[curIdx]);
            curIdx++;
        }
        while (curIdx < n && intervals[curIdx][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[curIdx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[curIdx][1]);
            curIdx++;
        }
        res.add(newInterval);

        while (curIdx < n) {
            res.add(intervals[curIdx]);
            curIdx++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
