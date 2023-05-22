public class LeetCode137 {

    // 遍历数组，每个数字的第i位二进制位做一次位运算，
    // 结果对3取余就是答案的第i位，
    // 时间复杂度O(n)，空间复杂度O(1)
//    public int singleNumber(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int res = 0;
//        for (int i = 0; i < 32; i++) {
//            int temp = 0;
//            for (int n : nums) {
//                temp += ((n >> i) & 1);
//            }
//            // 这里对3取余只可能是0或者1，1代表答案的二进制位在第i位是1
//            if ((temp % 3) != 0) {
//                res |= (1 << i);
//            }
//        }
//        return res;
//    }

    // 状态机
    // 设置a（右数第一位），b（右数第二位）两位保存当前状态，
    // 状态流转示例
    // (0)         (0)         (0)
    // 00 --(1)--> 01 --(1)--> 10 --(1)-->
    // |________________________________|
    // 输入为n
    // 可得公式 a = a^n&~b
    // 计算b前状态图根据计算a之后更新
    // 可得公式 b = b^n&~a
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            a = a^n&~b;
            b = b^n&~a;
        }
        return a;
    }

    public static void main(String[] args) {
        LeetCode137 l = new LeetCode137();
        System.out.println(l.singleNumber(new int[]{2,2,3,2})); // 3
        System.out.println(l.singleNumber(new int[]{0,1,0,1,0,1,99})); // 99
    }

}
