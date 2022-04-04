import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode199 {

//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        TreeNode lastNode = root;
//        Deque<TreeNode> deque1 = new ArrayDeque<>();
//        Deque<TreeNode> deque2 = new ArrayDeque<>();
//        deque1.offer(root);
//        while (!(deque1.isEmpty() && deque2.isEmpty())) {
//            lastNode = null;
//            while (!deque1.isEmpty()) {
//                lastNode = deque1.poll();
//                if (lastNode.left != null) {
//                    deque2.offer(lastNode.left);
//                }
//                if (lastNode.right != null) {
//                    deque2.offer(lastNode.right);
//                }
//            }
//            if (lastNode != null) {
//                res.add(lastNode.val);
//            }
//            lastNode = null;
//            while (!deque2.isEmpty()) {
//                lastNode = deque2.poll();
//                if (lastNode.left != null) {
//                    deque1.offer(lastNode.left);
//                }
//                if (lastNode.right != null) {
//                    deque1.offer(lastNode.right);
//                }
//            }
//            if (lastNode != null) {
//                res.add(lastNode.val);
//            }
//        }
//        return res;
//    }

    // optimize
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int size = deque.size();
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            size--;
            if (node.left != null) {
                deque.offer(node.left);
            }
            if (node.right != null) {
                deque.offer(node.right);
            }
            if (size == 0) {
                res.add(node.val);
                size = deque.size();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //
    }

}
