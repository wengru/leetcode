import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode78 {

    // backtracking
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (nums == null || nums.length == 0) {
//            return res;
//        }
//        backtracking(nums, 0, new boolean[nums.length], res);
//        return res;
//    }
//
//    void backtracking(int[] nums, int idx, boolean[] isUsed, List<List<Integer>> res) {
//        if (idx == nums.length) {
//            List<Integer> list = new ArrayList<>();
//            for (int i=0; i<isUsed.length; ++i) {
//                if (isUsed[i]) {
//                    list.add(nums[i]);
//                }
//            }
//            res.add(list);
//            return;
//        }
//        isUsed[idx] = true;
//        backtracking(nums, idx+1, isUsed, res);
//        isUsed[idx] = false;
//        backtracking(nums, idx+1, isUsed, res);
//    }

    // using stack
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (nums == null || nums.length == 0) {
//            return res;
//        }
//        Deque<Integer> deque = new ArrayDeque<>();
//        res.add(new ArrayList<>(deque));
//        dfs(nums, 0, res, deque);
//        return res;
//    }
//
//    void dfs(int[] nums, int idx, List<List<Integer>> res, Deque deque) {
//        if (idx >= nums.length) {
//            return;
//        }
//        dfs(nums, idx+1, res, deque);
//        deque.push(nums[idx]);
//        dfs(nums, idx+1, res, deque);
//        res.add(new ArrayList<>(deque));
//        deque.pop();
//    }

    // bit manipulation
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i=0; i<1<<nums.length; ++i) {
            List<Integer> list = new ArrayList<>();
            for (int j=0; j <nums.length; ++j) {
                if ((i>>j & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode78 l = new LeetCode78();
        // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        System.out.println(l.subsets(new int[]{1,2,3}));
        // [[],[0]]
        System.out.println(l.subsets(new int[]{0}));
    }

}
