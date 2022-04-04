public class LeetCode152 {

    // memory limit exceeded
//    public int maxProduct(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return Integer.MIN_VALUE;
//        }
//        int res = nums[0];
//        int[][] dp = new int[nums.length][nums.length];
//        for (int i=0; i<nums.length; ++i) {
//            dp[i][i] = nums[i];
//            res = Math.max(nums[i], res);
//        }
//        for (int i=0; i<nums.length; ++i) {
//            for (int j=i+1; j<nums.length; ++j) {
//                dp[i][j] = dp[i][j-1]*nums[j];
//                res = Math.max(res, dp[i][j]);
//            }
//        }
//        return res;
//    }

    // dynamic program
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int preOpt = nums[0] > 0 ? nums[0] : 0,  preNeg = nums[0] < 0 ? nums[0] : 0, res = nums[0];
        for (int i=1; i<nums.length; ++i) {
            int tempMax = Math.max(nums[i]*preNeg, nums[i]*preOpt), tempMin = Math.min(nums[i]*preNeg, nums[i]*preOpt);
            preOpt = nums[i] > tempMax ? nums[i] : tempMax;
            preOpt = preOpt > 0 ? preOpt : 0;
            preNeg = nums[i] < tempMin ? nums[i] : tempMin;
            preNeg = preNeg < 0 ? preNeg : 0;
            res = Math.max(res, preOpt);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode152 l = new LeetCode152();
        System.out.println(l.maxProduct(new int[]{2,3,-2,4})); // 6
        System.out.println(l.maxProduct(new int[]{-2,0,-1})); // 0
        System.out.println(l.maxProduct(new int[]{-2,3,-4})); // 24
    }

}
