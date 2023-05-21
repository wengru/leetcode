import java.util.ArrayList;
import java.util.List;

public class LeetCode257 {

    public void dfs(List<String> res, TreeNode node, String path) {
        if (node.left == null && node.right ==null) {
            res.add(path);
        } else {
            if (node.left != null) {
                dfs(res, node.left, path + "->" + node.left.val);
            }
            if (node.right != null) {
                dfs(res, node.right, path + "->" + node.right.val);
            }
        }
    }

    // dfs
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(res, root, "" + root.val);
        return res;
    }

    public static void main(String[] args) {
        //
    }

}
