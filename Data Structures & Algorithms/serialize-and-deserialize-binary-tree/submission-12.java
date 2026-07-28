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

public class Codec {
    private static final String NULL = "None";
    private static final String SEP = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(SEP);
        int[] index = new int[]{0};
        return dfs(nodes, index);
    }

    private TreeNode dfs(String[] nodes, int[] index) {
        String cur = nodes[index[0]];
        index[0]++;
        if (cur.equals(NULL)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = dfs(nodes, index);
        root.right = dfs(nodes, index);

        return root;
    }
}
