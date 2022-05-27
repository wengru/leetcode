public class LeetCode191 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n -= n&-n;
            res++;
        }
        return res;
    }

    // todo 分组统计
//    public int hammingWeight(int n) {
//        Integer.bitCount()
//    }

    public static void main(String[] args) {
        LeetCode191 l = new LeetCode191();
        System.out.println(l.hammingWeight(11)); // input: 00000000000000000000000000001011, output: 3
        System.out.println(l.hammingWeight(128)); // input: 00000000000000000000000010000000, output: 1
    }
}
