public class LeetCode260 {

    // 位运算
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        int sum = 0, k = -1;
        // 先求出总的异或和，等同于两个答案的异或和
        for (int n : nums) {
            sum ^= n;
        }
        // 找到异或和第一个1，异或和的某个二进制位为1代表这两个答案的这一位不同
        // 因为这是两个不同的数的异或和，k经过循环一定不为-1
        for (int i = 1; i < 32 && k == -1; i++) {
            if ((sum >> i & 1) == 1) {
                k = i;
            }
        }
        // 根据第k位是否为1把数组划分成两组，必然每组都有一个最终答案
        // 再通过异或运算获取最终答案
        for (int n : nums) {
            res[n >> k & 1] ^= n;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode260 l = new LeetCode260();
        TestUtil.printArray(l.singleNumber(new int[]{1,2,1,3,2,5})); // [3,5]
        TestUtil.printArray(l.singleNumber(new int[]{-1,0})); // [-1,0]
        TestUtil.printArray(l.singleNumber(new int[]{0,1})); // [1,0]
    }

}
