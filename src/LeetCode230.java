import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode230 {

    /*
    // 中序遍历
    public int kthSmallest(TreeNode root, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        return findKthNode(root, k, deque);
    }

    public int findKthNode(TreeNode root, int k, Deque<Integer> deque) {
        if (root.left != null) {
            int v = findKthNode(root.left, k, deque);
            if (v != -1) {
                return v;
            }
        }
        deque.push(root.val);
        if (deque.size() == k) {
            return root.val;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }
        if (root.right != null) {
            return findKthNode(root.right, k, deque);
        }
        return -1;
    }
     */

    // 优化后的版本，循环代替递归
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        int count = 0;
        while (!deque.isEmpty() || root != null) {
            if (root != null) {
                deque.push(root);
                root = root.left;
            } else {
                root = deque.pop();
                if (++count == k) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return -1;
    }

    public static void main(String args) {
        LeetCode230 l = new LeetCode230();
    }
}
