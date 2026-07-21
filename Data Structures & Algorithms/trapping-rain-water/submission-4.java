// class Solution {
//     public int trap(int[] height) {
//         if (height.length == 0) {
//             return 0;
//         }

//         Stack<Integer> stack = new Stack<>();
//         int res = 0;

//         for (int i = 0; i < height.length; i++) {
//             while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
//                 int mid = height[stack.pop()];
//                 if (!stack.isEmpty()) {
//                     int right = height[i];
//                     int left = height[stack.peek()];
//                     int h = Math.min(right, left) - mid;
//                     int w = i - stack.peek() - 1;
//                     res += h * w;
//                 }
//             }
//             stack.push(i);
//         }
//         return res;
//     }
// }

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int left = 0, right = n - 1;
        int lMax = 0, rMax = 0;
        int res = 0;
        while (left < right) {
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);
            if (lMax < rMax) {
                res += lMax - height[left];
                left++;
            } else {
                res += rMax - height[right];
                right--;
            }
        }
        return res;
    }
}
