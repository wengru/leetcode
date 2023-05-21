public class LeetCode41 {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i=0; i<nums.length; ++i) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                // swap two integer
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i=0; i<nums.length; ++i) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        LeetCode41 l = new LeetCode41();
//        System.out.println(l.firstMissingPositive(new int[]{1,2,0})); // 3
//        System.out.println(l.firstMissingPositive(new int[]{3,4,-1,1})); // 2
//        System.out.println(l.firstMissingPositive(new int[]{1})); // 2
//        System.out.println(l.firstMissingPositive(new int[]{1,1})); // 2
//        System.out.println(l.firstMissingPositive(new int[]{7,8,9,11,12})); // 1
        System.out.println(l.firstMissingPositive(new int[]{-1,2,5,3,1})); // 4
    }

}
