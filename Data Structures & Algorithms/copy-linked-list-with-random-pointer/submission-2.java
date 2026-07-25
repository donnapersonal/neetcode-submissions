/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> originToClone = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            if (!originToClone.containsKey(cur)) {
                originToClone.put(cur, new Node(cur.val));
            }
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            if (cur.next != null) {
                originToClone.get(cur).next = originToClone.get(cur.next);
            }

            if (cur.random != null) {
                originToClone.get(cur).random = originToClone.get(cur.random);
            }

            cur = cur.next;
        }

        return originToClone.get(head);
    }
}
