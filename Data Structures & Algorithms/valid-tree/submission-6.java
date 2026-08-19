class Solution {
    private int[] parent;
    private int[] size;

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!union(u, v)) {
                return false;
            }
        }
        return true;
    }

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return false;
        if (size[rootX] < size[rootY]) {
            int tmp = rootX;
            rootX = rootY;
            rootY = tmp;
        }
        parent[rootY] = rootX;
        size[rootX] += size[rootY];
        return true;
    }
}
