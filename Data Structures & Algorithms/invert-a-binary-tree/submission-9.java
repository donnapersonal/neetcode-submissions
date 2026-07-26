/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//         if (root == null) return null;
//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root);
//         while (!stack.isEmpty()) {
//             TreeNode cur = stack.pop();
//             TreeNode temp = cur.left;
//             cur.left = cur.right;
//             cur.right = temp;
//             if (cur.left != null) {
//                 stack.push(cur.left);
//             }

//             if (cur.right != null) {
//                 stack.push(cur.right);
//             }
//         }
//         return root;
//     }
// }

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.poll();
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                if (cur.left != null) {
                    deque.push(cur.left);
                }
                if (cur.right != null) {
                    deque.push(cur.right);
                }
            }
        }
        return root;
    }
}
