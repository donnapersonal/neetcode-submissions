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
//     public int kthSmallest(TreeNode root, int k) {
//         Deque<TreeNode> stack = new ArrayDeque<>();
//         while (root != null || !stack.isEmpty()) {
//             while (root != null) {
//                 stack.push(root);
//                 root = root.left;
//             }
//             TreeNode cur = stack.pop();
//             k--;
//             if (k == 0) {
//                 return cur.val;

//             }
//             root = cur.right;
//         }
//         return -1;
//     }
// }

class Solution {
    private int res = 0;
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
