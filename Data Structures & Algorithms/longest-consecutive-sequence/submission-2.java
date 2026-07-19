// class Solution {
//     public int longestConsecutive(int[] nums) {
//         Set<Integer> numSet = new HashSet<>();
//         for (int num : nums) {
//             numSet.add(num);
//         }

//         int n = numSet.size();
//         int res = 0;
//         for (int num : numSet) {
//             if (numSet.contains(num - 1)) {
//                 continue;
//             }

//             int nextNum = num + 1;
//             while (numSet.contains(nextNum)) {
//                 nextNum ++;
//             }
//             res = Math.max(res, nextNum - num);

//             if (res * 2 >= n) {
//                 break;
//             }
//         }
//         return res;
//     }
// }

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int res = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                res = Math.max(res, length);
            }
        }
        return res;
    }
}
