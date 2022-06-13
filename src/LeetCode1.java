import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; ++i) {
            if (map.get(target-nums[i]) == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{i, map.get(target-nums[i])};
            }
        }
        return new int[]{};
    }

}

