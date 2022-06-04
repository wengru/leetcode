public class LeetCode108 {

    // 递归+分治
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return createTreeNode(nums, 0, nums.length - 1);
    }

    public TreeNode createTreeNode(int[] nums, int left, int right) {
        int mid = (left + right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        if (mid > left) {
            node.left = createTreeNode(nums, left, mid - 1);
        }
        if (mid < right) {
            node.right = createTreeNode(nums, mid + 1, right);
        }
        return node;
    }

    public static void main(String[] args) {
        LeetCode108 l = new LeetCode108();
        l.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

}
