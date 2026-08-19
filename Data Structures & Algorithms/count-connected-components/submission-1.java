class Solution {
    private int[] parent;
    private int[] rank;
    private int count;

    public int countComponents(int n, int[][] edges) {
        count = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            union(u, v);
        }
        return count;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;
        if (rank[rootX] < rank[rootY]) {
            int tmp = rootX;
            rootX = rootY;
            rootY = tmp;
        }
        parent[rootY] = rootX;
        rank[rootX] += rank[rootY];
        count -= 1;
    }
}
