class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        int[] prices = new int[n];
        Arrays.fill(prices, INF);
        prices[src] = 0;
        for (int i = 0; i < k+1; i++) {
            int[] tmp = prices.clone();
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];
                if (prices[u] != INF) {
                    tmp[v] = Math.min(tmp[v], w + prices[u]);
                }
            }
            prices = tmp;
        }
        if (prices[dst] == INF) {
            return -1;
        }
        return prices[dst];
    }
}
