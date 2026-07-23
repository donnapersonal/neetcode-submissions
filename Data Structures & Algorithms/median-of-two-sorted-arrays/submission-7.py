# class Solution:
#     def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
#         if len(nums1) > len(nums2):
#             nums1, nums2 = nums2, nums1
        
#         m, n = len(nums1), len(nums2)
#         low, high = 0, m
#         half_len = (m + n + 1) // 2
#         while low <= high:
#             i = (low + high) // 2
#             j = half_len - i

#             if i < m and nums2[j - 1] > nums1[i]:
#                 low = i + 1
#             elif i > 0 and nums1[i - 1] > nums2[j]:
#                 high = i - 1
#             else:
#                 if i == 0: 
#                     max_of_left = nums2[j - 1]
#                 elif j == 0: 
#                     max_of_left = nums1[i - 1]
#                 else: 
#                     max_of_left = max(nums1[i - 1], nums2[j - 1])
                
#                 if (m + n) % 2 == 1:
#                     return max_of_left
                
#                 if i == m: 
#                     min_of_right = nums2[j]
#                 elif j == n: 
#                     min_of_right = nums1[i]
#                 else: 
#                     min_of_right = min(nums1[i], nums2[j])

#                 return (max_of_left + min_of_right) / 2.0

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        total_len = len(nums1) + len(nums2)
        if total_len % 2 == 1:
            return self.findKth(nums1, nums2, total_len // 2 + 1)
        else:
            left = self.findKth(nums1, nums2, total_len // 2)
            right = self.findKth(nums1, nums2, total_len // 2 + 1)
            return (left + right) / 2.0
        
    def findKth(self, nums1, nums2, k):
        len1, len2 = len(nums1), len(nums2)
        idx1, idx2 = 0,0
        while True:
            if len1 == idx1:
                return nums2[idx2 + k - 1]
            
            if len2 == idx2:
                return nums1[idx1 + k - 1]
            
            if k == 1:
                return min(nums1[idx1], nums2[idx2])
            
            newIdx1 = min(idx1 + k // 2 - 1, len1 - 1)
            newIdx2 = min(idx2 + k // 2 - 1, len2 - 1)
            pivot1, pivot2 = nums1[newIdx1], nums2[newIdx2]
            if pivot1 <= pivot2:
                k -= (newIdx1 - idx1 + 1)
                idx1 = newIdx1 + 1
            else:
                k -= (newIdx2 - idx2 + 1)
                idx2 = newIdx2 + 1
