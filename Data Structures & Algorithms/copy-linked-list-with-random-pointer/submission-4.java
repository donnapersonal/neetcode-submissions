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

// class Solution {
//     public Node copyRandomList(Node head) {
//         Map<Node, Node> originToClone = new HashMap<>();
//         Node cur = head;
//         while (cur != null) {
//             if (!originToClone.containsKey(cur)) {
//                 originToClone.put(cur, new Node(cur.val));
//             }
//             cur = cur.next;
//         }

//         cur = head;
//         while (cur != null) {
//             if (cur.next != null) {
//                 originToClone.get(cur).next = originToClone.get(cur.next);
//             }

//             if (cur.random != null) {
//                 originToClone.get(cur).random = originToClone.get(cur.random);
//             }

//             cur = cur.next;
//         }

//         return originToClone.get(head);
//     }
// }

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node clone = new Node(cur.val);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        cur = head;
        while (cur != null) {
            Node clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }

        cur = head;
        Node cloneHead = head.next;
        while (cur != null) {
            Node clone = cur.next;
            cur.next = clone.next;
            if (cur.next != null) {
                clone.next = cur.next.next;
            } else {
                clone.next = null;
            }
            cur = cur.next;
        }
        return cloneHead;
    }
}
