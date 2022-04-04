import java.util.PriorityQueue;

public class LeetCode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        // min heap
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
          (o1, o2) -> {
              return Integer.compare(o1.val, o2.val);
          }
        );
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.add(listNode);
            }
        }
        while (!queue.isEmpty()) {
            head.next = queue.poll();
            head = head.next;
            if (head.next != null) {
                queue.add(head.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LeetCode23 l = new LeetCode23();
        ListNode.iterateListNode(l.mergeKLists(
                new ListNode[]{
                        new ListNode(new int[]{1,4,5}),
                        new ListNode(new int[]{1,3,4}),
                        new ListNode(new int[]{2,6}),
                }
        )); // [1,1,2,3,4,4,5,6]
        ListNode.iterateListNode(l.mergeKLists(
                new ListNode[]{}
        )); // []
        ListNode.iterateListNode(l.mergeKLists(
                new ListNode[]{
                        null
                }
        )); // [[]]
    }

}
