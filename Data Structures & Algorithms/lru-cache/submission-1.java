class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}

class LRUCache {
    Map<Integer, Node> cache;
    int capacity;
    Node head = null; // points to the most recently used ele
    Node lru = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);

            // remove it from current spot and make it the MRU
            removeNode(node);
            insertNode(node);

            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // key exisiting node
            Node node = cache.get(key);
            // remove it from current spot and make it the MRU
            removeNode(node);

            // later step will create a new node, make it point at the existing key, then make it
            // the MRU
        }

        // else if its new, add key to map, create a new make it mru
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insertNode(newNode);

        // then check if cache greater than capacity, if yes remove lru
        if (cache.size() > capacity) {
            // remove LRU
            Node node = lru;
            removeNode(node);

            // remove from cache
            cache.remove(node.key);
        }
    }

    private void removeNode(Node node) {
        if (node == head) {
            node.prev = null;
            head = node.next;
            return;
        }

        if (node == lru) {
            lru  = node.prev;
            lru.next = null;
            return;
        }

        Node leftNode = node.prev;
        Node rightNode = node.next;

        leftNode.next = rightNode;
        rightNode.prev = leftNode;
    }

    private void insertNode(Node node) {
        if (head == null) {
            head = node;
            lru = node;
            return;
        }

        head.prev = node;
        node.next = head;
        head = node;
    }
}
