import java.util.ArrayList;
import java.util.List;

public class LeetCode442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i=0; i< nums.length; i++) {
            if (nums[i] < 0) {
                continue;
            }
            while (nums[i] != i+1 && nums[i] > 0 && nums[nums[i] - 1] > 0) {
                if (nums[i] == nums[nums[i] - 1]) {
                    result.add(nums[i]);
                    nums[nums[i] - 1] = -1;
                    break;
                }
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode442 l = new LeetCode442();
        System.out.println(l.findDuplicates(new int[]{4,3,2,7,8,2,3,1})); // [2,3]
        System.out.println(l.findDuplicates(new int[]{1,1,2})); // [1]
        System.out.println(l.findDuplicates(new int[]{1})); // []
    }

}
