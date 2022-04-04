import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(), curr;
        dummy.next = head;
        curr = dummy;
        while (curr != null && curr.next != null) {
            ListNode temp = curr.next, nextNode = curr.next;
            while (temp.next != null && temp.next.val == nextNode.val) {
                temp = temp.next;
            }
            if (temp == nextNode) {
                curr = curr.next;
            } else {
                curr.next = temp.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LeetCode82 l = new LeetCode82();
        ListNode.iterateListNode(l.deleteDuplicates(new ListNode(new int[]{1,2,3,3,4,4,5}))); // [1,2,5]
        ListNode.iterateListNode(l.deleteDuplicates(new ListNode(new int[]{1,1,1,2,3}))); // [2,3]
        ListNode.iterateListNode(l.deleteDuplicates(new ListNode(new int[]{1,1,1}))); // []
    }

}
