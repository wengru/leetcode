import java.util.ArrayList;
import java.util.List;

public class LeetCode39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        dfs(candidates, target, res, new ArrayList<Integer>(), 0);
        return res;
    }

    void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int idx) {
        // each cycle starts with itself to avoid repeating the results
        for (int i=idx; i<candidates.length; ++i) {
            if (candidates[i] == target) {
                list.add(target);
                res.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            } else if (candidates[i] > target) {
                continue;
            } else {
                list.add(candidates[i]);
                dfs(candidates, target-candidates[i], res, list, i);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode39 l = new LeetCode39();
        System.out.println(l.combinationSum(new int[]{2,3,6,7}, 7)); // [[2,2,3],[7]]
        System.out.println(l.combinationSum(new int[]{2,3,5}, 8)); // [[2,2,2,2],[2,3,3],[3,5]]
        System.out.println(l.combinationSum(new int[]{2}, 1)); // []
        System.out.println(l.combinationSum(new int[]{1}, 1)); // [[1]]
        System.out.println(l.combinationSum(new int[]{1}, 2)); // [[1,1]]
    }
}
