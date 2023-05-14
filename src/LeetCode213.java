public class LeetCode213 {

    // dp
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robMax(nums, 0, nums.length - 1), robMax(nums, 1, nums.length));
    }

    public int robMax(int[] nums, int start, int end) {
        int temp = 0, stepOne = nums[start], stepTwo = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            temp = Math.max(stepOne + nums[i], stepTwo);
            stepOne = stepTwo;
            stepTwo = temp;
        }
        return stepTwo;
    }

    public static void main(String[] args) {
        LeetCode213 l = new LeetCode213();
        System.out.println(l.rob(new int[]{1,2,3,1})); // 4
        System.out.println(l.rob(new int[]{1,2,3})); // 3
    }

}
