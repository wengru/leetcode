public class LeetCode92 {

    // 头插法
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode dummyStart = new ListNode(0, head), pre = dummyStart, temp = dummyStart, tail = temp, dummyEnd = new ListNode(-1);
//        int count = 1;
//        // 先定位到翻转开始的前一个结点
//        while (temp.next != null) {
//            if (++count == left) {
//                pre = temp.next;
//            }
//            tail = temp = temp.next;
//        }
//        // 给链表尾补充一个虚拟结点
//        tail.next = dummyEnd;
//        ListNode cur = pre.next, next = pre.next == null ? null : pre.next.next, start = pre;
//        // 头插法翻转
//        count = right - left + 1;
//        while (count-- > 0) {
//            temp = next.next;
//            cur.next = pre;
//            next.next = cur;
//            pre = cur;
//            cur = next;
//            next = temp;
//        }
//        // 删除虚拟节点
//        if (tail.next == dummyEnd) {
//            tail.next = null;
//        }
//        // 部分翻转的链表与原链表结合
//        start.next.next = cur == dummyEnd ? null : cur;
//        start.next = pre;
//        cur.next = temp == dummyEnd ? null : temp;
//        return dummyStart.next;
//    }

    public ListNode recursive(ListNode node, int count) {
        if (--count == 0) {
            return node;
        }
        ListNode next = recursive(node.next, count);
        node.next.next = node;
        node.next = null;
        return next;
    }

    // 递归
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        // 定位到链表开始翻转的前一个结点和链表翻转结束的后一个结点
        ListNode dummy = new ListNode(0, head), cur = dummy, start = dummy, end = null;
        for (int i = 1; i < left; i++) {
            start = start.next;
        }
        int count = 0;
        while (cur.next != null) {
            if (++count == left) {
                start = cur;
            }
            if (count == right) {
                end = cur.next.next;
            }
            cur = cur.next;
        }
        ListNode node = recursive(start.next, right - left + 1);
        start.next.next = end;
        start.next = node;
        return dummy.next;
    }

    public static void main(String[] args) {
        LeetCode92 l = new LeetCode92();
//        System.out.println(l.reverseBetween(new ListNode(new int[]{1,2,3,4,5}), 2, 4)); // [1,4,3,2,5]
//        System.out.println(l.reverseBetween(new ListNode(new int[]{5}), 1, 1)); // [5]
//        System.out.println(l.reverseBetween(new ListNode(new int[]{1,2,3,4,5}), 3, 5)); // [1,2,5,4,3]
        System.out.println(l.reverseBetween(new ListNode(new int[]{3,5}), 1, 2)); // [5,3]
    }

}
