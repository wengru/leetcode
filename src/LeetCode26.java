public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return process(nums, 1);
    }

    public int process(int[] nums, int k) {
        int idx = 0;
        for (int num : nums) {
            if (idx < k || num != nums[idx-k]) {
                nums[idx++] = num;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        LeetCode26 l = new LeetCode26();
        System.out.println(l.removeDuplicates(new int[]{1,1,2})); // 2
        System.out.println(l.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4})); // 5
    }

}
