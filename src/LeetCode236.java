public class LeetCode236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点是给定值中的一个，或者以及深度遍历到底了，就返回
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        // 找左子树里有没有给定值
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 找右子树里有没有给定值
        TreeNode right = lowestCommonAncestor(root.left, p, q);
        // 1、左右子树都有的话，且各一个的话，肯定就是这个节点是公共祖先了
        // 2、左右子树都没有的话和这个树节点没关系了，不管他
        // 3、左右子树有一个有的话，返回那个给定值的节点
        // 4、特殊情况，比如这个节点就是一个给定的节点，然后另一个给定节点是这个树的子节点，那就直接返回这个节点
        if (left != null && right != null) {
            return root;
        } else if (left == null && right == null) {
            return null;
        } else {
            return left == null ? right : left;
        }
    }

    public static void main(String[] args) {
        //
    }

}
