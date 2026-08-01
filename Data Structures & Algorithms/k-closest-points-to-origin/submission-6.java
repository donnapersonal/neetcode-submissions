// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//         PriorityQueue<int[]> pq = new PriorityQueue<>(
//             (point1, point2) -> Long.compare(
//                 distance(point2),
//                 distance(point1)
//             )
//         );
//         for (int[] point : points) {
//             if (pq.size() < k) {
//                 pq.offer(point);
//             } else {
//                 if (distance(point) < distance(pq.peek())) {
//                     pq.poll();
//                     pq.offer(point);
//                 }
//             }
//         }
//         int[][] res = new int[k][2];
//         for (int i = 0; i < k; i++) {
//             res[i] = pq.poll();
//         }

//         return res;
//     }

//     private long distance(int[] point) {
//         long x = point[0];
//         long y = point[1];
//         return x * x + y * y;
//     }
// }

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (point1, point2) -> Long.compare(
                distance(point2),
                distance(point1)
            )
        );
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] res = new int[k][2];
        int index = 0;
        while (!pq.isEmpty()) {
            res[index++] = pq.poll();
        }

        return res;
    }

    private long distance(int[] point) {
        long x = point[0];
        long y = point[1];
        return x * x + y * y;
    }
}
