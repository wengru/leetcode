import java.util.Arrays;

/**
 * @author hanxin
 * @date 2022/3/24 23:26
 */
public class LeetCode16 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        //fix one number, then use two pointer
        for (int i=0; i<nums.length-2; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1, k = nums.length-1;
            while (j < k) {
                if (Math.abs(target - (nums[i] + nums[j] + nums[k])) < Math.abs(target - res)) {
                    res = nums[i] + nums[j] + nums[k];
                }
                if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                    while (j < nums.length && nums[j] == nums[j-1]) {
                        j++;
                    }
                }
                else if (nums[i] + nums[j] + nums[k] > target) {
                    k--;
                    while (k > 0 && nums[k] == nums[k+1]) {
                        k--;
                    }
                }
                else {
                    return target;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode16 l = new LeetCode16();
        System.out.println(l.threeSumClosest(new int[]{-1,2,1,-4}, 1)); // 2
//        System.out.println(l.threeSumClosest(new int[]{-3,-2,-5,3,-4}, -1)); // -2
    }

}