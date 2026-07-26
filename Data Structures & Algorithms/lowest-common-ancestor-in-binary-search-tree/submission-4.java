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

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int low = Math.min(p.val, q.val);
        int high = Math.max(p.val, q.val);
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < low) {
                cur = cur.right;
            } else if (cur.val > high) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return null;
    }
}
