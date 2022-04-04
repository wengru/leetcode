public class LeetCode28 {

    // brute force
//    public int strStr(String haystack, String needle) {
//        if (haystack == null || haystack.isEmpty()) {
//            return (needle == null || needle.isEmpty()) ? 0 : -1;
//        }
//        char[] haystackChars = haystack.toCharArray();
//        char[] needleChars = needle.toCharArray();
//        for (int i=0; i<haystackChars.length; ++i) {
//            int count = i;
//            boolean flag = true;
//            for (int j=0; j<needleChars.length; ++j) {
//                if (count < haystack.length() && needleChars[j] == haystackChars[count++]) {
//                    continue;
//                } else {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag == true) {
//                return i;
//            }
//        }
//        return -1;
//    }

    // kmp
    public int strStr(String haystack, String needle) {
        return 0;
    }

    public static void main(String[] args) {
        LeetCode28 l = new LeetCode28();
        System.out.println(l.strStr("hello", "ll")); // 2
        System.out.println(l.strStr("aaaaa", "bba")); // -1
        System.out.println(l.strStr("", "")); // 0
    }

}
