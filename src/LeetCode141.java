import java.util.HashMap;
import java.util.Map;

public class LeetCode141 {

    // map
//    public boolean hasCycle(ListNode head) {
//        Map<ListNode, Integer> map = new HashMap<>();
//        while (head != null) {
//            if (map.containsKey(head)) {
//                return true;
//            }
//            map.put(head, 1);
//            head = head.next;
//        }
//        return false;
//    }

    // two pointer
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //
    }
}
