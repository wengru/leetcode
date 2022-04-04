import java.util.ArrayList;
import java.util.List;

public class LeetCode98 {

    /**
     * using order, running in a worry time complexity and space complexity
     */
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return false;
//        }
//        List<Integer> list = new ArrayList<>();
//        inOrder(root, list);
//        int preNum = list.get(0);
//        for (int i=1; i<list.size(); ++i) {
//            if (list.get(i) <= preNum) {
//                return false;
//            }
//            preNum = list.get(i);
//        }
//        return true;
//    }
//
//    public void inOrder(TreeNode node, List<Integer> list) {
//        if (node.left != null) {
//            inOrder(node.left, list);
//        }
//        list.add(node.val);
//        if (node.right != null) {
//            inOrder(node.right, list);
//        }
//    }

    /**
     * using inorder, a better solution
     */
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        this.pre = root.val;
        return isValidBST(root.right);
    }

    /**
     * using dfs, a better solution
     */
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return false;
//        }
//        return dfs(root.left, null, root) & dfs(root.right, root, null);
//    }
//
//    public boolean dfs(TreeNode node, TreeNode minNode, TreeNode maxNode) {
//        if (node == null) {
//            return true;
//        }
//        else if ((minNode == null || node.val > minNode.val) && (maxNode == null || node.val < maxNode.val)) {
//            return dfs(node.left, minNode, node) & dfs(node.right, node, maxNode);
//        } else {
//            return false;
//        }
//    }

    public static void main(String[] args) {
        LeetCode98 l = new LeetCode98();
    }

}
