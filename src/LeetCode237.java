public class LeetCode237 {

    // 4 5 1 9
    public void deleteNode(ListNode node) {
        while (node.next != null) {
            node.val = node.next.val;
            if (node.next.next != null) {
                node = node.next;
            } else {
                node.next = null;
            }
        }
    }

    public static void main(String[] args) {
        //
    }

}
