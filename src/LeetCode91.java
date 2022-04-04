public class LeetCode91 {

//    public int numDecodings(String s) {
//        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
//            return 0;
//        }
//        if (s.length() == 1) {
//            return 1;
//        }
//        if (s.length() == 2) {
//            return s.charAt(1) == '0' ? (s.charAt(0) - '0' < 3 ? 1 : 0) : (Integer.valueOf(s) <= 26 ? 2 : 1);
//        }
//        if (s.charAt(1) == '0') {
//            if (s.charAt(0) - '0' > 2) {
//                return 0;
//            }
//        }
//        int pre = 1, cur = s.charAt(1) == '0' ? 1 : (Integer.valueOf(s.substring(0,2)) <= 26 ? 2 : 1);
//        for (int i=2; i<s.length(); ++i) {
//            if (s.charAt(i) == '0') {
//                if (s.charAt(i-1) - '0' > 2 || s.charAt(i-1) == '0') {
//                    return 0;
//                } else {
//                    int temp = cur;
//                    cur = pre;
//                    pre = temp;
//                }
//            } else if (s.charAt(i-1) == '0') {
//                pre = cur;
//            } else {
//                int temp = cur;
//                cur = Integer.valueOf(s.substring(i-1, i+1)) <= 26 ? cur+pre : cur;
//                pre = temp;
//            }
//        }
//        return cur;
//    }

    // optimize
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        s = " " + s;
        int pre = 0, cur = 1;
        for (int i=1; i<s.length(); ++i) {
            int a = s.charAt(i) - '0', b = (s.charAt(i-1) - '0')*10 + a, temp = 0;
            if (1 <= a && a <=9) {
                temp = cur;
            }
            if (10 <= b && b <= 26) {
                temp += pre;
            }
            pre = cur;
            cur = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        LeetCode91 l = new LeetCode91();
        System.out.println(l.numDecodings("12")); // 2
        System.out.println(l.numDecodings("226")); // 3
        System.out.println(l.numDecodings("0")); // 0
        System.out.println(l.numDecodings("06")); // 0
        System.out.println(l.numDecodings("90")); // 0
        System.out.println(l.numDecodings("2101")); // 1
        System.out.println(l.numDecodings("301")); // 0
        System.out.println(l.numDecodings("12")); // 2
    }

}
