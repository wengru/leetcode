public class LeetCode110 {

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) == Integer.MAX_VALUE ? false : true;
    }

    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == Integer.MAX_VALUE || rightHeight == Integer.MAX_VALUE || Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MAX_VALUE;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        LeetCode110 l = new LeetCode110();
        //
    }
}
