import java.util.HashMap;

public class LeetCode138 {

    // time O(n), space O(n)
//    public Node copyRandomList(Node head) {
//        HashMap<Node, Node> map = new HashMap<>();
//        Node dummy = new Node(0), prevNode = head;
//        Node newNode = dummy;
//        // construct linked-list
//        while (prevNode != null) {
//            newNode.next = new Node(prevNode.val);
//            newNode = newNode.next;
//            map.put(prevNode, newNode);
//            prevNode = prevNode.next;
//        }
//        prevNode = head;
//        newNode = dummy.next;
//        while (prevNode != null) {
//            if (prevNode.random != null) {
//                newNode.random = map.get(prevNode.random);
//            }
//            newNode = newNode.next;
//            prevNode = prevNode.next;
//        }
//        return dummy.next;
//    }

    // time O(n), space O(1)
    public Node copyRandomList(Node head) {
        Node tempNode = head, dummy = new Node(0), tempNodePrev = head;
        while (tempNode != null) {
            Node copyNode = new Node(tempNode.val);
            copyNode.next = tempNode.next;
            copyNode.random = tempNode.random;
            tempNode.next = copyNode;
            tempNode = copyNode.next;
        }
        tempNode = dummy;
        while (tempNodePrev != null) {
            tempNodePrev.next.random = tempNodePrev.next.random == null ? null : tempNodePrev.next.random.next;
            tempNodePrev = tempNodePrev.next.next;
        }
        tempNodePrev = head;
        while (tempNodePrev != null) {
            tempNode.next = tempNodePrev.next;
            tempNodePrev.next = tempNodePrev.next.next;
            tempNode = tempNode.next;
            tempNodePrev = tempNodePrev.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        //
    }
}
