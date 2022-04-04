public class LeetCode104 {

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(findMaxDepth(root.left, 1), findMaxDepth(root.right, 1));
    }

    public int findMaxDepth(TreeNode root, int depthCount) {
        return root == null ? depthCount : Math.max(findMaxDepth(root.left, depthCount+1), findMaxDepth(root.right, depthCount+1));
    }

    public static void main(String[] args) {
        //
    }

}
