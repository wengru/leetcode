import java.util.HashMap;
import java.util.Map;

public class LeetCode142 {

    // map
//    public ListNode detectCycle(ListNode head) {
//        Map<ListNode, Integer> map = new HashMap<>();
//        while (head != null) {
//            if (map.containsKey(head)) {
//                return head;
//            }
//            map.put(head, 0);
//            head = head.next;
//        }
//        return null;
//    }

    // two pointer
    public ListNode detectCycle(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, quick = dummy;
        while (quick != null && quick.next != null) {
            if ((slow = slow.next) == (quick = quick.next.next)) {
                break;
            }
        }
        // 没有环，直接返回
        if (quick == null || quick.next == null) {
            return null;
        }
        slow = dummy;
        while (slow != quick) {
            slow = slow.next;
            quick = quick.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LeetCode142 l = new LeetCode142();
    }

}
