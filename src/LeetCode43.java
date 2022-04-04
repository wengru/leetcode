public class LeetCode43 {

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i=num1.length()-1; i>=0; --i) {
            for (int j=num2.length()-1; j >=0; --j) {
                int n = (num1.charAt(i)-'0')*(num2.charAt(j)-'0')+res[i+j+1];
                res[i+j+1] = n%10;
                res[i+j] += n/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<res.length; ++i) {
            if (sb.length() == 0 && res[i] == 0) {
                continue;
            }
            sb.append(res[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        LeetCode43 l = new LeetCode43();
        System.out.println(l.multiply("2", "3")); // "6"
        System.out.println(l.multiply("123", "456")); // "56088"
    }

}
