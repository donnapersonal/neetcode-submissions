// class Solution {
//     public int minCostConnectPoints(int[][] points) {
//         int n = points.length;
//         UF uf = new UF(n);
//         List<Edge> edges = new ArrayList<Edge>();
//         for (int i = 0; i < n; i++) {
//             for (int j = i+1; j < n; j++) {
//                 edges.add(new Edge(dist(points, i, j), i, j));
//             }
//         }
//         Collections.sort(edges, new Comparator<Edge>() {
//             public int compare(Edge edge1, Edge edge2) {
//                 return edge1.len - edge2.len;
//             }
//         });
//         int res = 0, num = 1;
//         for (Edge edge : edges) {
//             int len = edge.len, x = edge.x, y = edge.y;
//             if (uf.union(x, y)) {
//                 res += len;
//                 num++;
//                 if (num == n) break;
//             }
//         }
//         return res;
//     }

//     private int dist(int[][] points, int x, int y) {
//         return Math.abs(points[x][0] -  points[y][0]) + Math.abs(points[x][1] - points[y][1]);
//     }
// }

// class UF {
//     int[] parent;
//     int[] rank;
//     int n;

//     public UF(int n) {
//         this.n = n;
//         this.parent = new int[n];
//         for (int i = 0; i < n; i++) {
//             this.parent[i] = i;
//         }

//         this.rank = new int[n];
//         Arrays.fill(this.rank, Integer.MAX_VALUE);
//     }

//     public int find(int x) {
//         if (parent[x] == x) return x;
//         parent[x] = find(parent[x]);
//         return parent[x];
//     }

//     public boolean union(int x, int y) {
//         int rootX = find(x), rootY = find(y);
//         if (rootX == rootY) return false;
//         if (rank[rootX] < rank[rootY]) {
//             int tmp = rootX;
//             rootX = rootY;
//             rootY = tmp;
//         }
//         parent[rootY] = rootX;
//         rank[rootX] += rank[rootY];
//         return true;
//     }
// }

// class Edge {
//     int len, x, y;
//     public Edge(int len, int x, int y) {
//         this.len = len;
//         this.x = x;
//         this.y = y;
//     }
// }

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        int res = 0;
        for (int count = 0; count < n; count++) {
            int cur = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && (cur == -1 || minDist[i] < minDist[cur])) {
                    cur = i;
                }
            }
            visited[cur] = true;
            res += minDist[cur];
            for (int next = 0; next < n; next++) {
                if (!visited[next]) {
                    int dist = Math.abs(points[cur][0] - points[next][0]) + Math.abs(points[cur][1] - points[next][1]);
                    minDist[next] = Math.min(minDist[next], dist);
                }
            }
        }
        return res;
    }
}
