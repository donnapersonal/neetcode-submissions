// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         if (nums1.length > nums2.length) {
//             return findMedianSortedArrays(nums2, nums1);
//         }

//         int m = nums1.length, n = nums2.length;
//         int low = 0, high = m;
//         int halfLen = (m+n+1) / 2;
//         while (low <= high) {
//             int i = low + (high - low) / 2;
//             int j = halfLen - i;
//             if (i < m && j > 0 && nums2[j-1] > nums1[i]) {
//                 low = i + 1;
//             } else if (i > 0 && j < n && nums1[i-1] > nums2[j]) {
//                 high = i - 1;
//             } else {
//                 int maxOfLeft;
//                 if (i == 0) {
//                     maxOfLeft = nums2[j-1];
//                 } else if (j == 0) {
//                     maxOfLeft = nums1[i-1];
//                 } else {
//                     maxOfLeft = Math.max(nums1[i-1], nums2[j-1]);
//                 }

//                 if ((m + n) % 2 == 1) {
//                     return maxOfLeft;
//                 }

//                 int minOfRight;
//                 if (i == m) {
//                     minOfRight = nums2[j];
//                 } else if (j == n) {
//                     minOfRight = nums1[i];
//                 } else {
//                     minOfRight = Math.min(nums1[i], nums2[j]);
//                 }

//                 return ((double) maxOfLeft + minOfRight) / 2.0;
//             }
//         }
//         return 0.0;
//     }
// }

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        if (totalLen % 2 == 1) {
            return findKth(nums1, nums2, totalLen / 2 + 1);
        } else {
            int left = findKth(nums1, nums2, totalLen / 2);
            int right = findKth(nums1, nums2, totalLen / 2 + 1);
            return ((double) left + right) / 2.0;
        }
    }

    private int findKth(int[] arr1, int[] arr2, int k) {
        int len1 = arr1.length, len2 = arr2.length;
        int idx1 = 0, idx2 = 0;
        while (true) {
            if (len1 == idx1) {
                return arr2[idx2 + k - 1];
            }

            if (len2 == idx2) {
                return arr1[idx1 + k - 1];
            }

            if (k == 1) {
                return Math.min(arr1[idx1], arr2[idx2]);
            }

            int newIdx1 = Math.min(idx1 + k / 2 - 1, len1 - 1);
            int newIdx2 = Math.min(idx2 + k / 2 - 1, len2 - 1);
            int pivot1 = arr1[newIdx1], pivot2 = arr2[newIdx2];
            if (pivot1 <= pivot2) {
                k -= (newIdx1 - idx1 + 1);
                idx1 = newIdx1 + 1;
            } else {
                k -= (newIdx2 - idx2 + 1);
                idx2 = newIdx2 + 1;
            }

        }
    }
}

