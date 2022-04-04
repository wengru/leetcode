public class LeetCode209 {

//    public int minSubArrayLen(int target, int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int sum = nums[0], res = Integer.MAX_VALUE, left = 0, right = 0;
//        while (right < nums.length) {
//            if (sum > target) {
//                res = Math.min(res, right-left+1);
//                sum = sum - nums[left++];
//            } else if (sum < target) {
//                if (right == nums.length-1) {
//                    return res == Integer.MAX_VALUE ? 0 : res;
//                } else {
//                    sum = sum + nums[++right];
//                }
//            } else {
//                res = Math.min(res, right-left+1);
//                sum = sum - nums[left++];
//            }
//        }
//        return res == Integer.MAX_VALUE ? 0 : res;
//    }

    // tricky
//    public int minSubArrayLen(int target, int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int sum = nums[0], res = Integer.MAX_VALUE, left = 0, right = 0;
//        while (right < nums.length) {
//            if (sum < target) {
//                if (right == nums.length-1) {
//                    return res == Integer.MAX_VALUE ? 0 : res;
//                } else {
//                    sum = sum + nums[++right];
//                }
//            } else {
//                res = Math.min(res, right-left+1);
//                sum = sum - nums[left++];
//            }
//        }
//        return res == Integer.MAX_VALUE ? 0 : res;
//    }

    // binary-search
    public int minSubArrayLen(int target, int[] nums) {
        int left = 1, right = nums.length, res = 0;
        while (left <= right) {
            int mid = (left+right) >> 1;
            if (findArrayExist(nums, target, mid)) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    boolean findArrayExist(int[] nums, int target, int size) {
        int sum = 0;
        for (int i=0; i<nums.length; ++i) {
            if (i >= size) {
                sum -= nums[i - size];
            }
            sum += nums[i];
            if (sum >= target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode209 l = new LeetCode209();
        System.out.println(l.minSubArrayLen(11, new int[]{1,2,3,4,5})); // 3
        System.out.println(l.minSubArrayLen(7, new int[]{2,3,1,2,4,3})); // 2
        System.out.println(l.minSubArrayLen(4, new int[]{1,4,4})); // 1
        System.out.println(l.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1})); // 0
    }

}
