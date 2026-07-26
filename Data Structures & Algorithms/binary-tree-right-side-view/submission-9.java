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
    private List<Integer> res = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        traverse(root, 0);
        return res;
    }

    private void traverse(TreeNode root, int depth) {
        if (root == null) return;
        if (res.size() == depth) {
            res.add(root.val);
        }
        traverse(root.right, depth+1);
        traverse(root.left, depth+1);
    }
}
