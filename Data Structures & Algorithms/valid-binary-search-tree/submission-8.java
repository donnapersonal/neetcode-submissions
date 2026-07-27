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
//     public boolean isValidBST(TreeNode root) {
//         return validate(root, null, null);
//     }

//     private boolean validate(TreeNode root, TreeNode min, TreeNode max) {
//         if (root == null) return true;
//         if (min != null && root.val <= min.val) return false;
//         if (max != null && root.val >= max.val) return false;
//         return validate(root.left, min, root) && validate(root.right, root, max);
//     }
// }

// class Solution {
//     private long prev = Long.MIN_VALUE;

//     public boolean isValidBST(TreeNode root) {
//         return validate(root);
//     }

//     private boolean validate(TreeNode root) {
//         if (root == null) return true;
//         if (!validate(root.left)) return false;
//         if (root.val <= prev) return false;
//         prev = root.val;
//         return validate(root.right);
//     }
// }

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            if (prev != null && cur.val <= prev.val) return false;
            prev = cur;
            root = cur.right;
        }
        return true;
    }
}
