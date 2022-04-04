public class LeetCode129 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int preVal) {
        if (node == null || (node.left == null && node.right == null)) {
            return node == null ? 0 : preVal*10+node.val;
        }
        return dfs(node.left, preVal*10+node.val) + dfs(node.right, preVal*10+node.val);
    }

    public static void main(String[] args) {
        //
    }

}
