/**
 * @author hanxin
 * @date 2022/5/27 23:34
 */
public class LeetCode50 {

    // 递归
    /*public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1/x;
        }
        double res = myPow(x, n/2);
        double v = n > 0 ? x : 1/x;
        return res*res*((n&1) == 1 ? v : 1);
    }*/

    // 例如x^77，幂次方用二进制表示为101101，x^79，幂次方用二进制表示为101111
    // 依次对二进制值中为1的位置做对应幂次的累加乘，得到结果
    public double myPow(double x, int n) {
        double res = 1.0, multiplyValue = n > 0 ? x : 1/x;
        boolean flag = n > 0;
        while (n != 0) {
            if ((n&1) == 1) {
                res *= multiplyValue;
            }
            multiplyValue *= multiplyValue;
            n /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode50 l = new LeetCode50();
        System.out.println(l.myPow(2.0, 10)); // 1024.0
        System.out.println(l.myPow(2.1, 3)); // 9.261
        System.out.println(l.myPow(2.0, -2)); // 0.25
        System.out.println(l.myPow(-2.0, -2)); // 0.25
        System.out.println(l.myPow(-2, 0)); // 1
        System.out.println(l.myPow(34.00515, -3)); // 1
    }
}
