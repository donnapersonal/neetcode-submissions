// class Solution {
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         int INF = Integer.MAX_VALUE;
//         int[] prices = new int[n];
//         Arrays.fill(prices, INF);
//         prices[src] = 0;
//         for (int i = 0; i < k+1; i++) {
//             int[] tmp = prices.clone();
//             for (int[] flight : flights) {
//                 int u = flight[0];
//                 int v = flight[1];
//                 int w = flight[2];
//                 if (prices[u] != INF) {
//                     tmp[v] = Math.min(tmp[v], w + prices[u]);
//                 }
//             }
//             prices = tmp;
//         }
//         if (prices[dst] == INF) {
//             return -1;
//         }
//         return prices[dst];
//     }
// }

class Solution {
    private class State {
        int cost, stops, node;
        State(int cost, int stops, int node) {
            this.cost = cost;
            this.stops = stops;
            this.node = node;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            graph[u].add(new int[]{v, w});
        }

        PriorityQueue<State> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.cost, b.cost)
        );

        minHeap.offer(new State(0, 0, src));
        Map<String, Integer> visited = new HashMap<>();
        while (!minHeap.isEmpty()) {
            State cur = minHeap.poll();
            int cost = cur.cost;
            int stops = cur.stops;
            int node = cur.node;
        
            if (node == dst) {
                return cost;
            }
            if (stops > k) continue;
            String stateKey  = node + "," + stops;
            if (visited.containsKey(stateKey) && visited.get(stateKey) <= cost) {
                continue;
            }
            visited.put(stateKey, cost);

            for (int[] edge : graph[node]) {
                int nextNode = edge[0];
                int price = edge[1];
                int nextCost = cost + price;
                minHeap.offer(new State(nextCost, stops+1, nextNode));
            }
        }
        return -1;
    }
}
