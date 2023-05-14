import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode106 {

    private Integer idx = 0;

    // 左右子树
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        idx = postorder.length - 1;
        return buildChildTreeNode(postorder, map, 0, inorder.length - 1);
    }

    private TreeNode buildChildTreeNode(int[] postorder, Map<Integer, Integer> map, Integer left, Integer right) {
        if (left > right) {
            return null;
        }
        TreeNode treeNode = new TreeNode(postorder[idx--]);
        int mid = map.get(treeNode.val);
        treeNode.right = buildChildTreeNode(postorder, map, mid + 1, right);
        treeNode.left = buildChildTreeNode(postorder, map, left, mid - 1);
        return treeNode;
    }

    public static void main(String[] args) {
        LeetCode106 l = new LeetCode106();
//        l.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
//        l.buildTree(new int[]{2,1}, new int[]{2,1});
        l.buildTree(new int[]{1,2,3}, new int[]{3,2,1});
    }

}
