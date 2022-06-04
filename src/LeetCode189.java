public class LeetCode189 {

    // 先对数组全部反转，在根据k对数组做部分反转，需要遍历2次数组
    // 时间复杂度O(n)，空间复杂度O(1)
//    public void rotate(int[] nums, int k) {
//        if (k <= 0) {
//            return;
//        }
//        k = k%nums.length;
//        // 反转全部数组
//        helper(nums, 0, nums.length - 1);
//        // 前k个和其余部分分别反转
//        helper(nums, 0, k-1);
//        helper(nums, k, nums.length - 1);
//    }
//
//    public void helper(int[] nums, int start, int end) {
//        for (int i=start; i<(start + end + 1)/2; ++i) {
//            int temp = nums[i];
//            nums[i] = nums[end - (i - start)];
//            nums[end - (i - start)] = temp;
//        }
//    }

    // 把数组看成环形的，只需要遍历1次数组
    // 时间复杂度O(n)，空间复杂度O(1)
    public void rotate(int[] nums, int k) {
        if (k <= 0) {
            return;
        }
        k = k%nums.length;
        int hold = 0, temp = 0, count = 0, curIdx = 0;
        for (int start = 0; count < nums.length; ++start) {
            curIdx = start;
            hold = nums[start];
            do {
                temp = nums[(curIdx + k) % nums.length];
                nums[curIdx = (curIdx + k) % nums.length] = hold;
                hold = temp;
                count++;
            } while (curIdx != start);
        }
        int a = 0;
    }

    public static void main(String[] args) {
        LeetCode189 l = new LeetCode189();
        l.rotate(new int[]{1,2,3,4,5,6,7}, 3); // [5,6,7,1,2,3,4]
        l.rotate(new int[]{-1,-100,3,99}, 2); // [3,99,-1,-100]
    }

}
