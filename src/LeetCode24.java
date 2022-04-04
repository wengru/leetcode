import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode24 {

    // two pointer
//    public ListNode swapPairs(ListNode head) {
//        ListNode left, right, temp = head;
//        // left is point at the left node of current pair,
//        // and right is point at the right node of current pair;
//        while (temp != null) {
//            left = temp;
//            if (temp.next != null) {
//                right = temp.next;
//                swapVal(left, right);
//                temp = right.next;
//            } else {
//                temp = temp.next;
//            }
//        }
//        return head;
//    }

    // using stack
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        ListNode nextNode, dummy = temp;
        temp.next = head;
        Deque<ListNode> deque = new ArrayDeque<>();
        while (temp.next != null) {
            deque.push(temp.next);
            nextNode = temp.next.next;
            if (temp.next.next != null) {
                deque.push(temp.next.next);
                nextNode = temp.next.next.next;
            }
            while (!deque.isEmpty()) {
                temp.next = new ListNode(deque.pop().val);
                temp = temp.next;
            }
            temp.next = nextNode;
        }
        return dummy.next;
    }

    public void swapVal(ListNode l1, ListNode l2) {
        int tmp;
        tmp = l1.val;
        l1.val = l2.val;
        l2.val = tmp;
    }

    public static void main(String[] args) {
        LeetCode24 l = new LeetCode24();
//        ListNode.iterateListNode(l.swapPairs(new ListNode(new int[]{1,2,3,4,5,6,7,8}))); // [2,1,4,3,6,5,8,7]
        ListNode.iterateListNode(l.swapPairs(new ListNode(new int[]{1,2,3,4,5}))); // [2,1,4,3,5]
//        ListNode.iterateListNode(l.swapPairs(new ListNode(new int[]{1,2,3,4}))); // [2,1,4,3]
//        ListNode.iterateListNode(l.swapPairs(null)); // []
//        ListNode.iterateListNode(l.swapPairs(new ListNode(new int[]{1}))); // [1]
    }

}
