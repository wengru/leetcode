public class LeetCode67 {

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return "0";
        }
        char[] res = new char[Math.max(a.length(), b.length()) + 1];
        res[0] = '0';
        int carry = 0, aIdx = a.length() - 1, bIdx = b.length() - 1, idx = res.length - 1, temp = 0;
        while (aIdx != -1 || bIdx != -1 || carry > 0) {
            temp = (aIdx >= 0 ? a.charAt(aIdx--) - '0' : 0) + (bIdx >= 0 ? b.charAt(bIdx--) - '0' : 0) + carry;
            res[idx--] = (temp&1) == 1 ? '1' : '0';
            carry = temp >> 1;
        }
        return new String(res, res[0] == '0' ? 1 : 0, res[0] == '0' ? res.length - 1 : res.length);
    }

    public static void main(String[] args) {
        LeetCode67 l = new LeetCode67();
        System.out.println(l.addBinary("11", "1")); // "100"
        System.out.println(l.addBinary("1010", "1011")); // "10101"
//        System.out.println((char)('0' + (3&1)));
    }

}
