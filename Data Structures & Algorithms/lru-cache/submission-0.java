


class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;

    private final Node dummyHead;
    private final Node dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        dummyHead = new Node(0, 0);
        dummyTail = new Node(0, 0);

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtFront(Node node) {
        node.next = dummyHead.next;
        node.prev = dummyHead;

        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        insertAtFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            remove(node);
            insertAtFront(node);
            return;
        }

        if (map.size() == capacity) {
            Node lru = dummyTail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node node = new Node(key, value);
        insertAtFront(node);
        map.put(key, node);
    }
}
