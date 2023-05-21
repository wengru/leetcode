public class LeetCode206 {

    // 双指针
    public ListNode reverseList(ListNode head) {
        ListNode noddy = new ListNode(0, head), cur = head, pre = noddy, next = head == null ? null : head.next, temp;
        while (cur != null && next != null) {
            temp = next.next;
            cur.next = pre;
            next.next = cur;
            pre = cur;
            cur = next;
            next = temp;
        }
        if (head != null) {
            head.next = null;
        }
        return cur;
    }

    // 递归
//    public ListNode recursive(ListNode node) {
//        if (node.next == null) {
//            return node;
//        }
//        ListNode next = recursive(node.next);
//        node.next.next = node;
//        node.next = null;
//        return next;
//    }
//
//    public ListNode reverseList(ListNode head) {
//        if (head == null) {
//            return head;
//        }
//        ListNode node = recursive(head);
//        return node;
//    }

    public static void main(String[] args) {
        LeetCode206 l = new LeetCode206();
        System.out.println(l.reverseList(new ListNode(new int[]{1,2,3,4,5})));
    }

}
