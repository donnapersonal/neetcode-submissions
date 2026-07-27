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
//     private Map<Integer, Integer> valToIndex;
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         valToIndex = new HashMap<>();
//         for (int i = 0; i < inorder.length; i++) {
//             valToIndex.put(inorder[i], i);
//         }
//         return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
//     }

//     private TreeNode build(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
//         if (preStart > preEnd || inStart > inEnd) return null;
//         int rootVal = preorder[preStart];
//         int rootIndex = valToIndex.get(rootVal);
//         int leftSize = rootIndex - inStart;
//         TreeNode root = new TreeNode(rootVal);
//         root.left = build(preorder, preStart+1, preStart + leftSize, inStart, rootIndex - 1);
//         root.right = build(preorder, preStart + leftSize + 1, preEnd, rootIndex + 1, inEnd);
//         return root;
//     }
// }

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && inorderIndex < inorder.length && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
