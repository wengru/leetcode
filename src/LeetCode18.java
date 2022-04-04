import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        // two pointer + double circle + prune
        Arrays.sort(nums);
        for (int i=0; i<nums.length-3; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            // prune
            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
                continue;
            }
            if (nums[i] + nums[nums.length-3] + nums[nums.length-2] + nums[nums.length-1] < target) {
                continue;
            }
            for (int j=i+1; j<nums.length-2; ++j) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                // prune
                if (nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[nums.length-2] + nums[nums.length-1] < target) {
                    continue;
                }
                int left = j+1, right = nums.length-1;
                while (left < right) {
                    int temp = nums[i] + nums[j] + nums[left] + nums[right];
                    if (temp < target) {
                        left++;
                    } else if (temp > target) {
                        right--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        left++;
                        while (left < right && nums[left] == nums[left-1]) {
                            left++;
                        }
                        right--;
                        while (right > left && nums[right] == nums[right+1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode18 l = new LeetCode18();
        System.out.println(l.fourSum(new int[]{1,0,-1,0,-2,2}, 0)); // [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        System.out.println(l.fourSum(new int[]{}, 0)); // []
    }

}
