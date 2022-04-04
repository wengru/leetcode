import java.util.ArrayList;
import java.util.List;

public class LeetCode90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        res.add(new ArrayList<Integer>());
        backTracking(nums, res, -1, new ArrayList<Integer>());
        return res;
    }

    void backTracking(int[] nums, List<List<Integer>> res, int idx, List<Integer> list) {
        int preNum = -11;
        for (int i=idx+1; i<nums.length; ++i) {
            if (preNum == nums[i]) {
                continue;
            }
            list.add(preNum = nums[idx = i]);
            res.add(new ArrayList<>(list));
            backTracking(nums, res, idx, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        LeetCode90 l = new LeetCode90();
        System.out.println(l.subsetsWithDup(new int[]{1,2,2})); // [[],[1],[1,2],[1,2,2],[2],[2,2]]
        System.out.println(l.subsetsWithDup(new int[]{0})); // [[],[0]]
    }
    // [] [1] [1,2] [1,2,2] [1,2] [2] [2,2]
    // [[], [1], [1, 2], [1, 2, 2], [1, 2], [2], [2, 2], [2]]
}
