public class LeetCode86 {

    public ListNode partition(ListNode head, int x) {
        ListNode splitNode = new ListNode(0), dummy = splitNode;
        splitNode.next = head;
        while (splitNode.next != null && splitNode.next.val < x) {
            splitNode = splitNode.next;
        }
        if (splitNode.next == null) {
            return head;
        }
        ListNode node = splitNode.next;
        while (node.next != null) {
            if (node.next.val < x) {
                swapNode(splitNode, node);
                splitNode = splitNode.next;
            } else {
                node = node.next;
            }
        }
        return dummy.next;
    }

    void swapNode(ListNode leftNode, ListNode rightNode) {
        ListNode tempNode = rightNode.next;
        rightNode.next = tempNode.next;
        tempNode.next = leftNode.next;
        leftNode.next = tempNode;
    }

    public static void main(String[] args) {
        LeetCode86 l = new LeetCode86();
        ListNode.iterateListNode(l.partition(new ListNode(new int[]{1,4,3,2,5,2}), 3)); // [1,2,2,4,3,5]
        ListNode.iterateListNode(l.partition(new ListNode(new int[]{2,1}), 2)); // [1,2]
    }

}
