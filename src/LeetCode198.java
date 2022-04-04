public class LeetCode198 {

    // 每个地方偷或者不偷，就和前面两个地方有直接关系
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int robedOne = 0, robedTwo = 0, temp = 0;
        for (int i=0; i<nums.length; ++i) {
            temp = Math.max(nums[i] + robedOne, robedTwo);
            robedOne = robedTwo;
            robedTwo = temp;
        }
        return Math.max(robedOne, robedTwo);
    }

    public static void main(String[] args) {
        LeetCode198 l = new LeetCode198();
        System.out.println(l.rob(new int[]{1,2,3,1})); // 4
        System.out.println(l.rob(new int[]{2,7,9,3,1})); // 12
    }

}
