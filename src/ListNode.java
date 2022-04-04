public class ListNode {

    /**
     * Definition for singly-linked list.
     */
    ListNode() {}

    int val;

    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (int v : vals) {
            head.next = new ListNode(v);
            head = head.next;
        }
        if (dummy.next != null) {
            this.val = dummy.next.val;
            this.next = dummy.next.next;
        }
    }

    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    public static String iterateListNode(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (listNode != null) {
            sb.append(listNode.val);
            sb.append(", ");
            listNode = listNode.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
        return sb.toString();
    }

//    @Override
//    public String toString() {
//        return "ListNode{" +
//                "val=" + val +
//                ", next=" + next +
//                '}';
//    }

}
