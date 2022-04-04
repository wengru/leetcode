import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DoubleLinkedNode {

        /**
         * previous node
         */
        DoubleLinkedNode prev;

        /**
         * next node
         */
        DoubleLinkedNode next;

        /**
         * the key of node, also the key of map
         */
        Integer key;

        /**
         * the value of the node
         */
        Integer value;

        public DoubleLinkedNode() {}

        public DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DoubleLinkedNode(int key, int value, DoubleLinkedNode prev, DoubleLinkedNode next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public int getVal() {
            return this.value;
        }

    }

    Map<Integer, DoubleLinkedNode> map;

    DoubleLinkedNode head;

    DoubleLinkedNode tail;

    /**
     * the max size of LinkedList
     */
    Integer capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap(capacity);
        this.capacity = capacity;
        this.head = new DoubleLinkedNode(0, 0);
        this.tail = new DoubleLinkedNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // move the node to the head of linked list, only switch pointer
            DoubleLinkedNode node = map.get(key);
            this.removeNode(node);
            this.addNode(node);
            return node.getVal();
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // if key is exist, update value, and move to head
            DoubleLinkedNode node = map.get(key);
            node.value = value;
            this.removeNode(node);
            this.addNode(node);

        } else {
            // if key is not exist, insert to head of linked list, and put key-value into map
            DoubleLinkedNode node = new DoubleLinkedNode(key, value, head, head.next);
            if (map.size() == capacity) {
                // evicts the tail of node
                map.remove(tail.prev.key);
                this.removeNode(tail.prev);
            }
            map.put(key, node);
            this.addNode(node);
        }
    }

    /**
     * add node into head
     * @param node
     */
    public void addNode(DoubleLinkedNode node) {
        node.prev = this.head;
        node.next = this.head.next;
        node.next.prev = node;
        this.head.next = node;
    }

    public DoubleLinkedNode removeNode(DoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

}
