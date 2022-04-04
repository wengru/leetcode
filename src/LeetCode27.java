public class LeetCode27 {

    // two pointer
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int idx = 0;
        for (int num : nums) {
            if (num != val) {
                nums[idx++] = num;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        LeetCode27 l = new LeetCode27();
        System.out.println(l.removeElement(new int[]{3,2,2,3}, 3)); // 2, [2,2]
        System.out.println(l.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2)); // 5, [0,1,3,0,4]
    }

}
