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
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         int low = Math.min(p.val, q.val);
//         int high = Math.max(p.val, q.val);
//         TreeNode cur = root;
//         while (cur != null) {
//             if (cur.val < low) {
//                 cur = cur.right;
//             } else if (cur.val > high) {
//                 cur = cur.left;
//             } else {
//                 return cur;
//             }
//         }
//         return null;
//     }
// }

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         while (true) {
//             if (root.val > p.val && root.val > q.val) {
//                 root = root.left;
//             } else if (root.val < p.val && root.val < q.val) {
//                 root = root.right;
//             } else {
//                 break;
//             }
//         }
//         return root;
//     }
// }

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         TreeNode cur = root;
//         while (cur != null) {
//             if (cur.val > q.val && cur.val > p.val) {
//                 cur = cur.left;
//             } else if (cur.val < q.val && cur.val < p.val) {
//                 cur = cur.right;
//             } else {
//                 return cur;
//             }
//         }
//         return null;
//     }
// }

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         int low = Math.min(p.val, q.val);
//         int high = Math.max(p.val, q.val);
//         return find_lca(root, low, high);
//     }

//     private TreeNode find_lca(TreeNode root, int low, int high) {
//         if (root == null) return null;
//         if (root.val < low) {
//             return find_lca(root.right, low, high);
//         }
        
//         if (root.val > high) {
//             return find_lca(root.left, low, high);
//         } 
//         return root;
//     }
// }

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        if (root.val > q.val) {
            return lowestCommonAncestor(root.left, q, p);
        }
        if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
