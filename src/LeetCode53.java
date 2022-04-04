import java.util.Arrays;

public class LeetCode53 {

    // dynamic program, time complexity O(n), space complexity O(1)
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int preMaxVal = nums[0], maxVal = nums[0];
        for (int i=1; i<nums.length; ++i) {
            maxVal = Math.max(maxVal, preMaxVal = preMaxVal > 0 ? nums[i] + preMaxVal : nums[i]);
        }
        return maxVal;
    }

    // divide and conquer
//    public int maxSubArray(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return Integer.MIN_VALUE;
//        }
//        return divideAndConquer(nums, 1, nums.length);
//    }
//
//    int divideAndConquer(int[] nums, int left, int right) {
//        if (left == right) {
//            return nums[left-1];
//        }
//        int mid = (left + right) >> 1;
//        int leftMax = nums[left-1], rightMax = nums[right-1];
//        for (int i=left; i<mid; ++i) {
//            leftMax = leftMax > 0 ? nums[i] + leftMax : nums[i];
//        }
//        for (int i = right-2; i>=mid; --i) {
//            rightMax = rightMax > 0 ? nums[i] + rightMax : nums[i];
//        }
//        int leftSubVal = divideAndConquer(nums, left, mid);
//        int rightSubVal = divideAndConquer(nums, mid+1, right);
//        return Math.max(leftMax + rightMax, leftSubVal > rightSubVal ? leftSubVal : rightSubVal);
//    }

    public static void main(String[] args) {
        LeetCode53 l = new LeetCode53();
        System.out.println(l.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); // 6
        System.out.println(l.maxSubArray(new int[]{1})); // 1
        System.out.println(l.maxSubArray(new int[]{5,4,-1,7,8})); // 23
    }

}
