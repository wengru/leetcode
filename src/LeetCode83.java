public class LeetCode83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        while (head != null) {
            while (head.next != null && head.next.val == head.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LeetCode83 l = new LeetCode83();
//        ListNode.iterateListNode(l.deleteDuplicates(new ListNode(new int[]{1,1,2}))); // [1,2]
//        ListNode.iterateListNode(l.deleteDuplicates(new ListNode(new int[]{1,1,2,3,3}))); // [1,2,3]
        ListNode.iterateListNode(l.deleteDuplicates(new ListNode(new int[]{1,1,1}))); // [1]
    }

}
