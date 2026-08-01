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

// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//         PriorityQueue<int[]> pq = new PriorityQueue<>(
//             (point1, point2) -> Long.compare(
//                 distance(point2),
//                 distance(point1)
//             )
//         );
//         for (int[] point : points) {
//             pq.offer(point);
//             if (pq.size() > k) {
//                 pq.poll();
//             }
//         }
//         int[][] res = new int[k][2];
//         int index = 0;
//         while (!pq.isEmpty()) {
//             res[index++] = pq.poll();
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
        quickSelect(points, 0, points.length - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    private void quickSelect(int[][] points, int left, int right, int kSmallest) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(points, left, right);

        if (pivotIndex == kSmallest) {
            return;
        } else if (kSmallest < pivotIndex) {
            quickSelect(points, left, pivotIndex - 1, kSmallest);
        } else {
            quickSelect(points, pivotIndex + 1, right, kSmallest);
        }
    }

    private int partition(int[][] points, int left, int right) {
        int pivot = distance(points[right]);
        int i = left;

        for (int j = left; j < right; j++) {
            if (distance(points[j]) <= pivot) {
                swap(points, i, j);
                i++;
            }
        }

        swap(points, i, right);
        return i;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
