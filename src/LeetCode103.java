import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode103 {

    // stack + stack
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.push(root);
        while (!(stack1.isEmpty() && stack2.isEmpty())) {
            List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
            while (!stack1.isEmpty()) {
                if (stack1.peek().left != null) {
                    stack2.push(stack1.peek().left);
                }
                if (stack1.peek().right != null) {
                    stack2.push(stack1.peek().right);
                }
                list1.add(stack1.pop().val);
            }
            while (!stack2.isEmpty()) {
                if (stack2.peek().right != null) {
                    stack1.push(stack2.peek().right);
                }
                if (stack2.peek().left != null) {
                    stack1.push(stack2.peek().left);
                }
                list2.add(stack2.pop().val);
            }
            if (list1.size() != 0) {
                res.add(list1);
            }
            if (list2.size() != 0) {
                res.add(list2);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //
    }

}
