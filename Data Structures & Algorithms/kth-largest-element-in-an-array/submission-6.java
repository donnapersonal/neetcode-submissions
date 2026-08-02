// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for (int num : nums) {
//             pq.offer(num);
//             if (pq.size() > k) {
//                 pq.poll();
//             }
//         }
//         return pq.peek();
//     }
// }

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickselect(nums, 0, n - 1, n - k);
    }

    private int quickselect(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[k];
        }

        int x = nums[l];
        int i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (nums[i] < x);

            do {
                j--;
            } while (nums[j] > x);

            if (i < j) {
                swap(nums, i, j);
            }
        }
        if (k <= j) {
            return quickselect(nums, l, j, k);
        } else {
            return quickselect(nums, j + 1, r, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
