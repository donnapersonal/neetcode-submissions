// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         Deque<Integer> deque = new ArrayDeque<>();
//         int[] res = new int[n-k+1];
//         int idx = 0;
//         for (int i = 0; i < n; i++) {
//             if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
//                 deque.pollFirst();
//             }

//             while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
//                 deque.pollLast();
//             }

//             deque.offerLast(i);
//             if (i >= k - 1) {
//                 res[idx++] = nums[deque.peekFirst()];
//             }
//         }
//         return res;
//     }
// }

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> que = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(b[0], a[0]);
                }
                return Integer.compare(b[1], a[1]);
            }
        );
        for (int i = 0; i < k; i ++) {
            que.offer(new int[]{nums[i], i});
        }

        int[] res = new int[n-k+1];
        res[0] = que.peek()[0];
        for (int i = k; i < n; i++) {
            que.offer(new int[]{nums[i], i});
            while (que.peek()[1] <= i - k) {
                que.poll();
            }
            res[i-k+1] = que.peek()[0];
        }
        return res;
    }
}
