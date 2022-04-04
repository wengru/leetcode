public class LeetCode169 {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length < 0) {
            return 0;
        }
        int winner = nums[0], count = 1;
        for (int i=1; i<nums.length; ++i) {
            if (winner == nums[i]) {
                count++;
            } else if (count == 0) {
                winner = nums[i];
                count++;
            } else {
                count--;
            }
        }
        return winner;
    }

    public static void main(String[] args) {
        LeetCode169 l = new LeetCode169();
        System.out.println(l.majorityElement(new int[]{3,2,3})); // 3
        System.out.println(l.majorityElement(new int[]{2,2,1,1,1,2,2})); // 2
    }

}
