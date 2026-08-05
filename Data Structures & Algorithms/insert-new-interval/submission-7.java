// class Solution {
//     public int[][] insert(int[][] intervals, int[] newInterval) {
//         List<int[]> res = new ArrayList<>();
//         int n = intervals.length;
//         int curIdx = 0;
//         while (curIdx < n && intervals[curIdx][1] < newInterval[0]) {
//             res.add(intervals[curIdx]);
//             curIdx++;
//         }
//         while (curIdx < n && intervals[curIdx][0] <= newInterval[1]) {
//             newInterval[0] = Math.min(newInterval[0], intervals[curIdx][0]);
//             newInterval[1] = Math.max(newInterval[1], intervals[curIdx][1]);
//             curIdx++;
//         }
//         res.add(newInterval);

//         while (curIdx < n) {
//             res.add(intervals[curIdx]);
//             curIdx++;
//         }
//         return res.toArray(new int[res.size()][]);
//     }
// }

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int left = newInterval[0], right = newInterval[1];
        boolean placed = false;
        for (int[] interval : intervals) {
            int l = interval[0], r = interval[1];
            if (l > right) {
                if (!placed) {
                    res.add(new int[]{left, right});
                    placed = true;
                }
                res.add(new int[]{l, r});
            } else if (r < left) {
                res.add(new int[]{l, r});
            } else {
                left = Math.min(left, l);
                right = Math.max(right, r);
            }
        }
        if (!placed) {
            res.add(new int[]{left, right});
        }
        return res.toArray(new int[res.size()][]);
    }
}
