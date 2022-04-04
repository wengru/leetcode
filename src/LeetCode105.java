import java.math.BigDecimal;
import java.util.Arrays;

public class LeetCode105 {

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
//            return null;
//        }
//        TreeNode root = new TreeNode(preorder[0]);
//        // 找到preorder[0]在indorder中的位置，preorder[0]是根节点
//        int rootIdx = -1;
//        for (int i=0; i<inorder.length; ++i) {
//            if (inorder[rootIdx = i] == preorder[0]) {
//                break;
//            }
//        }
//        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIdx + 1), Arrays.copyOfRange(inorder, 0, rootIdx));
//        root.right = buildTree(Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length), Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length));
//        return root;
//    }

    // 优化底层数组拷贝带来的额外空闲时间复杂度
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        TreeNode res = buildTreeRecursion(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return res;
    }

    TreeNode buildTreeRecursion(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        if (pLeft > pRight || iLeft > iRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pLeft]);
        if (pLeft == pRight) {
            return root;
        }
        // 找到preorder[0]在indorder中的位置，preorder[0]是根节点
        int rootIdx = -1;
        for (int i=iLeft; i<=iRight; ++i) {
            if (inorder[rootIdx = i] == preorder[pLeft]) {
                break;
            }
        }
        root.left = buildTreeRecursion(preorder, pLeft+1, pLeft+rootIdx-iLeft, inorder, iLeft, rootIdx-1);
        root.right = buildTreeRecursion(preorder, pLeft+rootIdx-iLeft+1, pRight, inorder, rootIdx+1, iRight);
        return root;
    }

    public static void main(String[] args) {
        LeetCode105 l = new LeetCode105();
        l.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        l.buildTree(new int[]{-1}, new int[]{-1});
    }

}
