public class LeetCode287 {

    // 原地哈希
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i=0; i<nums.length; i++) {
            while (nums[i] != i+1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    return nums[i];
                }
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode287 l = new LeetCode287();
        System.out.println(l.findDuplicate(new int[]{1,3,4,2,2})); // 2
        System.out.println(l.findDuplicate(new int[]{3,1,3,4,2})); // 3
    }

}
