// class Solution {
//     public boolean checkValidString(String s) {
//         int low = 0, high = 0;
//         for (char ch : s.toCharArray()) {
//             if (ch == '(') {
//                 low++;
//                 high++;
//             } else if (ch == ')') {
//                 low--;
//                 high--;
//             } else {
//                 low--;
//                 high++;
//             }

//             if (high < 0) {
//                 return false;
//             }
//             low = Math.max(low, 0);
//         }
//         return low == 0;
//     }
// }

class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> leftStack = new ArrayDeque<>();
        Deque<Integer> starStack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftStack.push(i);
            } else if (ch == '*') {
                starStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        while (!leftStack.isEmpty() && !starStack.isEmpty()) {
            int leftIdx = leftStack.pop();
            int starIdx = starStack.pop();
            if (leftIdx > starIdx) {
                return false;
            }
        }
        return leftStack.size() == 0;
    }
}
