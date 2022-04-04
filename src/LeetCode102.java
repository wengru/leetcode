import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int size = deque.size();
        while (!deque.isEmpty()) {
            if (deque.peek().left != null) {
                deque.offer(deque.peek().left);
            }
            if (deque.peek().right != null) {
                deque.offer(deque.peek().right);
            }
            list.add(deque.poll().val);
            if (--size == 0) {
                size = deque.size();
                res.add(list);
                list = new ArrayList<>();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //
    }

}
