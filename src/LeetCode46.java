import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, res, new ArrayDeque<>());
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<List<Integer>> res, Deque<Integer> deque) {
        if (deque.size() == nums.length) {
            List<Integer> list = new ArrayList<>(deque);
            res.add(list);
            return;
        }
        for (int i=0; i<used.length; ++i) {
            if (!used[i]) {
                used[i] = true;
                deque.push(nums[i]);
                dfs(nums, used, res, deque);
                used[i] = false;
                deque.pop();
            }
        }
    }

    public static void main(String[] args) {
        LeetCode46 l = new LeetCode46();
        // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        System.out.println(l.permute(new int[]{1,2,3}));
        // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        System.out.println(l.permute(new int[]{1,2,3}));
        // [[0,1],[1,0]]
        System.out.println(l.permute(new int[]{0,1}));
        // [[1]]
        System.out.println(l.permute(new int[]{1}));
    }

}
