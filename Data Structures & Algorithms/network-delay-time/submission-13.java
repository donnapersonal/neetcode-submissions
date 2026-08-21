// class Solution {
//     public int networkDelayTime(int[][] times, int n, int k) {
//         Map<Integer, List<int[]>> graph = new HashMap<>();
//         for (int[] time : times) {
//             int u = time[0];
//             int v = time[1];
//             int w = time[2];
//             graph.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[]{v, w});
//         }

//         PriorityQueue<int[]> minHeap = new PriorityQueue<>(
//             (a, b) -> Integer.compare(a[0], b[0])
//         );
//         minHeap.offer(new int[]{0, k});
//         Map<Integer, Integer> dist = new HashMap<>();
//         while (!minHeap.isEmpty()) {
//             int[] cur = minHeap.poll();
//             int curTime = cur[0];
//             int curNode = cur[1];
//             if (dist.containsKey(curNode)) continue;
//             dist.put(curNode, curTime);
//             for (int[] nxt : graph.getOrDefault(curNode, new ArrayList<>())) {
//                 int nextNode = nxt[0];
//                 int w = nxt[1];
//                 if (!dist.containsKey(nextNode)) {
//                     minHeap.offer(new int[]{curTime + w, nextNode});
//                 }
//             }
//         }

//         if (dist.size() != n) return -1;

//         int res = 0;
//         for (int time : dist.values()) {
//             res = Math.max(res, time);
//         }

//         return res;
//     }
// }

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph[u].add(new int[]{v, w});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], a[1])
        );
        minHeap.offer(new int[]{0, k});
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int curTime = cur[0];
            int curNode = cur[1];
            if (curTime > dist[curNode]) continue;
            for (int[] nxt : graph[curNode]) {
                int nextNode = nxt[0];
                int time = nxt[1];
                int newTime = time + curTime;
                if (newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;
                    minHeap.offer(new int[]{newTime, nextNode});
                }
            }
        }

        int res = 0;
        for (int node = 1; node <= n; node++) {
            if (dist[node] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, dist[node]);
        }
        return res;
    }
}
