class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int low = 0, high = m;
        int halfLen = (m+n+1) / 2;
        while (low <= high) {
            int i = low + (high - low) / 2;
            int j = halfLen - i;
            if (i < m && j > 0 && nums2[j-1] > nums1[i]) {
                low = i + 1;
            } else if (i > 0 && j < n && nums1[i-1] > nums2[j]) {
                high = i - 1;
            } else {
                int maxOfLeft;
                if (i == 0) {
                    maxOfLeft = nums2[j-1];
                } else if (j == 0) {
                    maxOfLeft = nums1[i-1];
                } else {
                    maxOfLeft = Math.max(nums1[i-1], nums2[j-1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxOfLeft;
                }

                int minOfRight;
                if (i == m) {
                    minOfRight = nums2[j];
                } else if (j == n) {
                    minOfRight = nums1[i];
                } else {
                    minOfRight = Math.min(nums1[i], nums2[j]);
                }

                return ((double) maxOfLeft + minOfRight) / 2.0;
            }
        }
        return 0.0;
    }
}
