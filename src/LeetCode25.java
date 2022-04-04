import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode25 {

    // using stack
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode currNode = new ListNode(0, head);
//        ListNode leftNode, rightNode, dummy = currNode;
//        Deque<ListNode> deque = new ArrayDeque<>();
//        while (currNode.next != null) {
//            int count = k;
//            leftNode = currNode;
//            while (count-- > 0 && currNode.next != null) {
//                deque.push(currNode.next);
//                currNode = currNode.next;
//            }
//            rightNode = currNode.next;
//            if (count < 0) {
//                currNode = leftNode;
//                while (!deque.isEmpty()) {
//                    currNode.next = deque.pop();
//                    currNode = currNode.next;
//                }
//                currNode.next = rightNode;
//            }
//        }
//        return dummy.next;
//    }

    // insert in the tail
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode currNode = new ListNode(0, head);
        ListNode leftNode, rightNode, dummy = currNode;
        while (currNode.next != null) {
            int count = k;
            leftNode = currNode;
            while (count-- > 0 && currNode.next != null) {
                currNode = currNode.next;
            }
            if (count < 0) {
                rightNode = leftNode.next;
                while (leftNode.next != currNode) {
                    ListNode movedNode = leftNode.next;
                    leftNode.next = movedNode.next;
                    movedNode.next = currNode.next;
                    currNode.next = movedNode;
                }
                currNode = rightNode;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LeetCode25 l = new LeetCode25();
        ListNode.iterateListNode(l.reverseKGroup(new ListNode(new int[]{1,2,3,4,5}), 1)); //[1,2,3,4,5]
        ListNode.iterateListNode(l.reverseKGroup(new ListNode(new int[]{1,2,3,4,5}), 2)); //[2,1,4,3,5]
        ListNode.iterateListNode(l.reverseKGroup(new ListNode(new int[]{1,2,3,4,5}), 3)); //[3,2,1,4,5]
        ListNode.iterateListNode(l.reverseKGroup(new ListNode(new int[]{1}), 1)); //[1]
    }
}
