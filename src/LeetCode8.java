/**
 * @author hanxin
 * @date 2022/3/24 22:55
 */
public class LeetCode8 {

    public int myAtoi(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int res = 0;
        int sign = 1;
        int i = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '\t' || c == ' ') {
                i++;
                continue;
            }
            else {
                break;
            }
        }
        if (i >= s.length()) {
            return 0;
        }
        if (chars[i] == '-' || chars[i] == '+') {
            sign = chars[i++] == '-' ? -sign : sign;
        }
        for (; i<chars.length; ++i) {
            if (chars[i] > 47 && chars[i] < 58) {
                int n = res;
                n*=10;
                n += chars[i] - 48;
                if (n/10 != res) {
                    // Integer overflow
                    return sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                res = n;
            }
            else {
                break;
            }
        }
        return res*sign;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode8().myAtoi("-2147483648"));
    }
}

