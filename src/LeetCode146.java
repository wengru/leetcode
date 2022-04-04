import java.util.HashMap;
import java.util.Map;

public class LeetCode146 {

    /**
     * [\"LRUCache\", \"put\", \"put\", \"get\", \"put\", \"get\", \"put\", \"get\", \"get\", \"get\"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     */
    /**
     * initialize (capacity: 2)
     * cache.put(1,1);  [(1,1)]
     * cache.put(2,2);  [(2,2),(1,1)]
     * cache.get(1);    [(1,1),(2,2)]  return 1
     * cache.put(3,3);  [(3,3),(1,1)]  evicts key 2
     * cache.get(2);    [(3,3),(1,1)]  return -1(not found)
     * cache.put(3,3);  [(4,4),(3,3)]  evicts key 1
     * cache.get(1);    [(4,4),(3,3)]  return -1(not found)
     * cache.get(3);    [(3,3),(4,4)]  return 3
     * cache.get(4);    [(4,4),(3,3)]  return 4
     */

    /**
     * doubleLinkedList + hashmap
     */
//    class LRUCache {
//
//        class DoubleLinkedNode {
//
//            /**
//             * previous node
//             */
//            DoubleLinkedNode prev;
//
//            /**
//             * next node
//             */
//            DoubleLinkedNode next;
//
//            /**
//             * the key of node, also the key of map
//             */
//            Integer key;
//
//            /**
//             * the value of the node
//             */
//            Integer value;
//
//            public DoubleLinkedNode() {}
//
//            public DoubleLinkedNode(int key, int value) {
//                this.key = key;
//                this.value = value;
//            }
//
//            public DoubleLinkedNode(int key, int value, DoubleLinkedNode prev, DoubleLinkedNode next) {
//                this.key = key;
//                this.value = value;
//                this.prev = prev;
//                this.next = next;
//            }
//
//            public int getVal() {
//                return this.value;
//            }
//
//        }
//
//        Map<Integer, DoubleLinkedNode> map;
//
//        DoubleLinkedNode head;
//
//        DoubleLinkedNode tail;
//
//        /**
//         * the max size of LinkedList
//         */
//        Integer capacity;
//
//        public LRUCache(int capacity) {
//            this.map = new HashMap(capacity);
//            this.capacity = capacity;
//            this.head = new DoubleLinkedNode(0, 0);
//            this.tail = new DoubleLinkedNode(0, 0);
//        }
//
//        public int get(int key) {
//            if (map.containsKey(key)) {
//                // move the node to the head of linked list, only switch pointer
//                DoubleLinkedNode node = map.get(key);
//                this.removeNode(node);
//                this.addNode(node);
//                return node.getVal();
//            } else {
//                return -1;
//            }
//        }
//
//        public void put(int key, int value) {
//            if (map.containsKey(key)) {
//                // if key is exist, update value, and move to head?
//                map.get(key).value = value;
//            } else {
//                // if key is not exist, insert to head of linked list, and put key-value into map
//                DoubleLinkedNode node = new DoubleLinkedNode(key, value, head, head.next);
//                if (map.size() == capacity) {
//                    // evicts the tail of node
//                    map.remove(tail.prev.key);
//                    this.removeNode(tail.prev);
//                }
//                map.put(key, node);
//            }
//        }
//
//        public void addNode(DoubleLinkedNode node) {
//            node.prev = this.head;
//            node.next = this.head.next;
//            node.next.prev = node;
//            this.head.next = node;
//        }
//
//        public DoubleLinkedNode removeNode(DoubleLinkedNode node) {
//            node.prev.next = node.next;
//            node.next.prev = node.prev;
//            return node;
//        }
//
//    }

    public static void main(String[] args) {
        LRUCache l = new LRUCache(2);
//        l.put(1, 1);
//        l.put(2, 2);
//        l.get(1);
//        l.put(3, 3);
//        l.get(2);
//        l.put(4, 4);
//        l.get(1);
//        l.get(3);
//        l.get(4);
        l.put(2,1);
        l.put(1,1);
        l.put(2,3);
        l.put(4,1);
        l.get(1);
        l.get(2);
    }

}
