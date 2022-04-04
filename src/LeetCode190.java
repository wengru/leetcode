public class LeetCode190 {

    // you need treat n as an unsigned value
    // ungraceful
//    public int reverseBits(int n) {
//        int res = 0, m = n, i=30;
//        n = n >> 1;
//        while (i-- > 0) {
//            res = res | (n & 1);
//            res = res << 1;
//            n = n >> 1;
//        }
//        res = res | (m < 0 ? 1 : 0);
//        res += (m & 1) == 0 ? 0 : Integer.MIN_VALUE;
//        return res;
//    }

//    public int reverseBits(int n) {
//        int i = 31, res = 0;
//        while (i-- > 0) {
//            res |= n & 1;
//            res <<= 1;
//            n >>= 1;
//        }
//        res |= n & 1;
//        return res;
//    }

    public int reverseBits(int n) {
        n = ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1); // 2位互换
        n = ((n & 0xCCCCCCCC) >>> 2) | ((n & 0x33333333) << 2); // 4位互换
        n = ((n & 0xF0F0F0F0) >>> 4) | ((n & 0x0F0F0F0F) << 4); // 8位互换
        n = ((n & 0xFF00FF00) >>> 8) | ((n & 0x00FF00FF) << 8); // 16位互换
        n = ((n & 0xFFFF0000) >>> 16) | ((n & 0x0000FFFF) << 16); // 32位互换
        return n;
    }

    public static void main(String[] args) {
        LeetCode190 l = new LeetCode190();
        System.out.println(l.reverseBits(-3)); // intput: 11111111111111111111111111111101, output: -1073741825
    }

}
