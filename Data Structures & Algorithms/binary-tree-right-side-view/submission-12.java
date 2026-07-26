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
//     private List<Integer> res = new ArrayList<>();
    
//     public List<Integer> rightSideView(TreeNode root) {
//         traverse(root, 0);
//         return res;
//     }

//     private void traverse(TreeNode root, int depth) {
//         if (root == null) return;
//         if (res.size() == depth) {
//             res.add(root.val);
//         }
//         traverse(root.right, depth+1);
//         traverse(root.left, depth+1);
//     }
// }

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> que = new ArrayDeque<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            TreeNode last = que.peek();
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();
                if (cur.right != null) que.offer(cur.right);
                if (cur.left != null) que.offer(cur.left);
            }
            res.add(last.val);
        }
        return res;
    }
}
