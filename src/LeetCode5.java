public class LeetCode5 {

    public String longestPalindrome(String s) {
        // dynamic programming
        boolean[][] dp = new boolean[s.length()][s.length()];
        int sLeft = 0, sRight = 0, maxLength = 0;
        for (int i=s.length()-1; i>=0; --i) {
            for (int j=i; j<s.length(); ++j) {
                dp[i][j] = j - i < 3 ? s.charAt(i) == s.charAt(j) : dp[i+1][j-1] & (s.charAt(i) == s.charAt(j));
                if (dp[i][j] && j - i > maxLength) {
                    maxLength = (sRight = j) - (sLeft = i);
                }
            }
        }
        return s.substring(sLeft, sRight + 1);
    }

    // central diffusion
//    public String longestPalindrome(String s) {
//        int maxLength = 0, start = -1;
//
//        for (int i = 0; i < s.length(); i++) {
//            int length = Math.max(getLength(i, i, s), getLength(i, i + 1, s));
//
//            if (maxLength < length) {
//                maxLength = length;
//                start = i - (length - 1) / 2;
//            }
//        }
//
//        return s.substring(start, start + maxLength);
//    }
//
//    private int getLength(int i, int j, String s) {
//        if (j >= s.length()) return 0;
//
//        int length = (i == j) ? -1 : 0;
//
//        while (i >= 0 && j < s.length()) {
//            if (s.charAt(i) != s.charAt(j)) break;
//
//            length += 2;
//            i--; j++;
//        }
//
//        return length;
//    }

    public static void main(String[] args) {
        System.out.println(new LeetCode5().longestPalindrome("abbad"));
    }

}

