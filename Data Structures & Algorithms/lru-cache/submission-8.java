// class LRUCache {
//     private final int cap;
//     private final LinkedHashMap<Integer, Integer> cache;
//     public LRUCache(int capacity) {
//         this.cap = capacity;
//         this.cache = new LinkedHashMap<>();
//     }
    
//     public int get(int key) {
//         if (!cache.containsKey(key)) {
//             return -1;
//         }

//         makeRecent(key);
//         return cache.get(key);
//     }
    
//     public void put(int key, int value) {
//         if (cache.containsKey(key)) {
//             cache.put(key, value);
//             makeRecent(key);
//             return;
//         }

//         if (cache.size() >= cap) {
//             int oldestkey = cache.keySet().iterator().next();
//             cache.remove(oldestkey);
//         }

//         cache.put(key, value);
//     }

//     private void makeRecent(int key) {
//         int value = cache.remove(key);
//         cache.put(key, value);
//     }
// }

class LRUCache {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node() {};
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int cap;
    private final Map<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addToHead(newNode);
        if (cache.size() > cap) {
            Node removed = removeTail();
            cache.remove(removed.key);
        }
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node removeTail() {
        Node lruNode = tail.prev;
        removeNode(lruNode);
        return lruNode;
    }
}
