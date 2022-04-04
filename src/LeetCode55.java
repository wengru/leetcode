public class LeetCode55 {

    /**
     * greedy
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        int idx = 0;
        while (nums[idx] != 0 && idx + nums[idx] < nums.length-1) {
            int maxStep = idx+1, tempIdx=idx;
            for (int j=idx+1; j<=idx+nums[idx]; ++j) {
                if (j+nums[j] >= nums.length) {
                    return true;
                }
                maxStep = j + nums[j] >= maxStep ? (tempIdx=j)+nums[j] : maxStep;
            }
            idx = tempIdx;
        }
        return idx+nums[idx] < nums.length-1 ? false : true;
    }

    public static void main(String[] args) {
        LeetCode55 l = new LeetCode55();
//        System.out.println(l.canJump(new int[]{2,3,1,1,4})); // true
//        System.out.println(l.canJump(new int[]{3,2,1,0,4})); // false
        System.out.println(l.canJump(new int[]{3,0,8,2,0,0,1})); // true
    }

}
