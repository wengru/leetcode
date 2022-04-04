public class LeetCode461 {

    public int hammingDistance(int x, int y) {
        int n = x^y, count = 0;
        while (n > 0) {
            count += n&1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode461 l = new LeetCode461();
        System.out.println(l.hammingDistance(1,4)); // 2
        System.out.println(l.hammingDistance(3,1)); // 1
    }

}
