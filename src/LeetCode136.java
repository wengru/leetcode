public class LeetCode136 {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preNum = 0;
        for (int  num : nums) {
            preNum = preNum^num;
        }
        return preNum;
    }

    public static void main(String[] args) {
        LeetCode136 l = new LeetCode136();
        System.out.println(l.singleNumber(new int[]{2,2,1})); // 1
        System.out.println(l.singleNumber(new int[]{4,1,2,1,2})); // 4
        System.out.println(l.singleNumber(new int[]{1})); // 1
    }

}
