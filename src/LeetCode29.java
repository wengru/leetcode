public class LeetCode29 {

    public int divide(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        if (divisor == 1 || divisor == -1) {
            return divisor == -1 && dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : dividend*divisor;
        }
        int res = 0, isNegative = (dividend > 0) ^ (divisor  > 0) ? -1 : 1;
        int dividendTmp = Math.abs(dividend == Integer.MIN_VALUE ? dividend+1 : dividend), divisorTmp = Math.abs(divisor);
        while (dividendTmp >= divisorTmp) {
            int tmp = Math.abs(divisor), count = 1;
            while ((tmp << 1 < dividendTmp) && (tmp << 1 > 0)) {
                tmp <<= 1;
                count <<= 1;
            }
            dividendTmp -= tmp;
            res += count;
        }
        return isNegative*(dividend == Integer.MIN_VALUE && dividendTmp+1 == divisorTmp ? res+1 : res);
    }

    public static void main(String[] args) {
        LeetCode29 l = new LeetCode29();
        System.out.println(l.divide(10, 3)); // 3
        System.out.println(l.divide(7, -3)); // -2
        System.out.println(l.divide(0, 1)); // 0
        System.out.println(l.divide(1, 1)); // 1
        System.out.println(l.divide(-1, 1)); // -1
        System.out.println(l.divide(1, 2)); // 0
        System.out.println(l.divide(-2147483648, -1)); // 2147483647
        System.out.println(l.divide(-2147483648, -2)); // 1073741824
        System.out.println(l.divide(-2, -2147483648)); // 0
    }

}
