public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l = head;
        int forward = 0;
        while (l1 != null || l2 != null || forward != 0) {
            l = l.next = new ListNode(((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + forward)%10);
            forward = ((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + forward)/10;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return head.next;
    }

}
