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
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         if (p == null && q == null) return true;
//         if (p == null || q == null) return false;
//         if (p.val != q.val) return false;
//         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//     }
// }

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{p, q});

        while (!stack.isEmpty()) {
            TreeNode[] node = stack.pop();
            TreeNode node1 = node[0];
            TreeNode node2 = node[1];
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;
            stack.push(new TreeNode[]{node1.left, node2.left});
            stack.push(new TreeNode[]{node1.right, node2.right});
        }
        return true;
    }
}
