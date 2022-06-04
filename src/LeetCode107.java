import java.util.*;

public class LeetCode107 {

    // 广度优先遍历构造结果数组
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        int len = 1;
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            // 当len自减到0的时候说明当前子数组构造完成，加入结果数组并初始化len构造下一个子数组
            while (len-- > 0) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                list.add(node.val);
            }
            len = deque.size();
            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        LeetCode107 l = new LeetCode107();
    }

}
