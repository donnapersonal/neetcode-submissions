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
    public int goodNodes(TreeNode root) {
        return dfs(root, -1000000000);
    }

    private int dfs(TreeNode root, int maxVal) {
        if (root == null) return 0;
        int res = 0;
        if (root.val >= maxVal) {
            res += 1;
            maxVal = root.val;
        }
        res += dfs(root.left, maxVal) + dfs(root.right, maxVal);
        return res;
    }
}
