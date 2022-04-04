import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            //fix one number, then use two pointer
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }
                else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    j++;
                    k--;
                    // if pointer moved and the number compare to before pointer move is same, move continue
                    while (j < nums.length && nums[j] == nums[j-1]) {
                        j++;
                    }
                    while (k > 0 && nums[k] == nums[k+1]) {
                        k--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode15 l = new LeetCode15();
        System.out.println(l.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
