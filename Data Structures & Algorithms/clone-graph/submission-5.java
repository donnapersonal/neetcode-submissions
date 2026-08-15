/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// class Solution {
//     Map<Node, Node> visited = new HashMap<>();

//     public Node cloneGraph(Node node) {
//         if (node == null) return null;
//         return dfs(node);
//     }

//     private Node dfs(Node node) {
//         if (visited.containsKey(node)) {
//             return visited.get(node);
//         }

//         Node cloned = new Node(node.val);
//         visited.put(node, cloned);
//         for (Node nei : node.neighbors) {
//             cloned.neighbors.add(dfs(nei));
//         }
//         return cloned;
//     }
// }

class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        visited.put(node, new Node(node.val));
        Queue<Node> que = new LinkedList<>();
        que.offer(node);

        while (!que.isEmpty()) {
            Node cur = que.poll();
            for (Node nei : cur.neighbors) {
                if (!visited.containsKey(nei)) {
                    visited.put(nei, new Node(nei.val));
                    que.offer(nei);
                }
                visited.get(cur).neighbors.add(visited.get(nei));
            }
        }
        return visited.get(node);
    }
}