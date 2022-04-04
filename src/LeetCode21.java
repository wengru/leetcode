public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode dummy = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head = head.next = l1;
                l1 = l1.next;
            } else {
                head = head.next = l2;
                l2 = l2.next;
            }
        }
        head.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public  static void main (String[] args) {

    }

}
