class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length, m = queries.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        int[] res = new int[m];
        Arrays.fill(res, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        );
        int index = 0;
        for (int[] queryPair : sortedQueries) {
            int query = queryPair[0];
            int original_idx = queryPair[1];
            while (index < n && intervals[index][0] <= query) {
                int left = intervals[index][0];
                int right = intervals[index][1];
                int size = right - left + 1;
                pq.offer(new int[]{size, right});
                index++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < query) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                res[original_idx] = pq.peek()[0];
            }
        }
        return res;
    }
}
