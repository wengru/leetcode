import java.util.ArrayList;
import java.util.List;

public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // two pointer, right pointer move n step in advance
        ListNode left = head, right = head;
        while (n-- > 0 && right != null) {
            right = right.next;
        }
        // the length of linked list less than n
        if (n >= 0) {
            return head;
        }
        // delete eth node while n is the length of linked list
        if (right == null) {
            return head.next;
        }
        while (right != null) {
            if (right.next == null) {
                left.next = left.next.next;
                break;
            }
            else {
                left = left.next;
                right = right.next;
            }
        }
        return head;
    }

    // using stack
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        List<ListNode> list = new ArrayList<>();
//        ListNode listNode = head;
//        while (listNode != null) {
//            list.add(listNode);
//            listNode = listNode.next;
//        }
//        if (list.size() < n) {
//            return head;
//        } else if (list.size() == n) {
//            return list.get(0).next;
//        } else if (n == 1) {
//            list.get(list.size()-2).next = null;
//        } else {
//            list.get(list.size()-n-1).next = list.get(list.size()-n+1);
//        }
//        return head;
//    }

    public static void main(String[] args) {
        //
    }
}
