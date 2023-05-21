import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 时间复杂度 构造方法O(h)，next()通常为O(1)，最差为O(h)，hasNext()为O(1)，
 * 空间复杂度O(h)
 * 其中h为树的高度
 */
public class BSTIterator {

    Deque<TreeNode> deque = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        // 先中序遍历到第一个值
       dfsLeft(root);
    }

    public int next() {
        TreeNode node = deque.pop();
        dfsLeft(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !deque.isEmpty();
    }

    private void dfsLeft(TreeNode root) {
        while (root != null) {
            deque.push(root);
            root = root.left;
        }
    }

}
