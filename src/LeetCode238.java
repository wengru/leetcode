public class LeetCode238 {

    // 前缀和求解
    // 时间复杂度O(n)，空间复杂度O(n)
//    public int[] productExceptSelf(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return new int[0];
//        }
//        int[] left = new int[nums.length + 2], right = new int[nums.length + 2];
//        left[0] = right[nums.length + 1] = 1;
//        for (int i = 1; i <= nums.length; ++i) {
//            left[i] = nums[i - 1]*left[i - 1];
//        }
//        for (int i = nums.length; i > 0; --i) {
//            right[i] = nums[i - 1]*right[i + 1];
//        }
//        int[] res = new int[nums.length];
//        for (int i = 1; i <= nums.length; ++i) {
//            res[i - 1] = left[i - 1]*right[i + 1];
//        }
//        return res;
//    }

    // 前缀和求解优化
    // 时间复杂度O(n)，空间复杂度O(1)
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 1, j = 1; i <= nums.length; ++i) {
            res[i - 1] = j;
            j *= nums[i - 1];
        }
        for (int i = nums.length, j = 1; i > 0; --i) {
            res[i - 1] *= j;
            j *= nums[i - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode238 l = new LeetCode238();
        l.productExceptSelf(new int[]{1,2,3,4}); // [24,12,8,6]
        l.productExceptSelf(new int[]{-1,1,0,-3,3}); // [0,0,9,0,0]
    }
}
