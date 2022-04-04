import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtracking(candidates, target, res, 0, new ArrayList<>());
        return res;
    }

    void backtracking(int[] candidates, int target, List<List<Integer>> res, int idx, List<Integer> tempList) {
        int preNum = Integer.MAX_VALUE;
        for (int i = idx; i < candidates.length; ++i) {
            if (candidates[i] == preNum) {
                continue;
            }
            if (candidates[i] == target) {
                tempList.add(target);
                res.add(new ArrayList<>(tempList));
                tempList.remove(tempList.size()-1);
                break;
            } else if (candidates[i] < target) {
                preNum = candidates[i];
                tempList.add(candidates[i]);
                backtracking(candidates, target-candidates[i], res, i+1, tempList);
                tempList.remove(tempList.size()-1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode40 l = new LeetCode40();
        /**
         * [
         * [1,1,6],
         * [1,2,5],
         * [1,7],
         * [2,6]
         * ]
         */
        System.out.println(l.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        /**
         * [
         * [1,2,2],
         * [5]
         * ]
         */
        System.out.println(l.combinationSum2(new int[]{2,5,2,1,2}, 5));
    }

}
