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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> que = new ArrayDeque<>();
        que.offer(root);
        int depth = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();
                if (cur.left != null) que.offer(cur.left);
                if (cur.right != null) que.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }
}
