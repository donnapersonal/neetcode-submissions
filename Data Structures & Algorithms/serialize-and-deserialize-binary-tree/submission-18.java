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

// public class Codec {
//     private static final String NULL = "None";
//     private static final String SEP = ",";

//     // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {
//         StringBuilder sb = new StringBuilder();
//         dfs(root, sb);
//         return sb.toString();
//     }

//     private void dfs(TreeNode root, StringBuilder sb) {
//         if (root == null) {
//             sb.append(NULL).append(SEP);
//             return;
//         }
//         sb.append(root.val).append(SEP);
//         dfs(root.left, sb);
//         dfs(root.right, sb);
//     }

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//         String[] nodes = data.split(SEP);
//         int[] index = new int[]{0};
//         return dfs(nodes, index);
//     }

//     private TreeNode dfs(String[] nodes, int[] index) {
//         String cur = nodes[index[0]];
//         index[0]++;
//         if (cur.equals(NULL)) {
//             return null;
//         }

//         TreeNode root = new TreeNode(Integer.parseInt(cur));
//         root.left = dfs(nodes, index);
//         root.right = dfs(nodes, index);

//         return root;
//     }
// }

public class Codec {
    private static final String NULL = "#";
    private static final String SEP = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node != null) {
                res.append(node.val).append(SEP);
                que.offer(node.left);
                que.offer(node.right);
            } else {
                res.append(NULL).append(SEP);
            }
        }

        res.setLength(res.length() - 1);

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(SEP);
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int index =1;
        while (!que.isEmpty()) {
            TreeNode parent = que.poll();
            String leftValue = nodes[index];
            index++;
            if (!leftValue.equals(NULL)) {
                parent.left = new TreeNode(Integer.parseInt(leftValue));
                que.offer(parent.left);
            }

            String rightValue = nodes[index];
            index++;
            if (!rightValue.equals(NULL)) {
                parent.right = new TreeNode(Integer.parseInt(rightValue));
                que.offer(parent.right);
            }
        }
        return root;
    }
}
