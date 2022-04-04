/**
 * @author hanxin
 * @date 2022/3/24 22:56
 */
import java.util.HashMap;
import java.util.Map;

public class LeetCode10 {

    // trash code
//    public boolean isMatch(String s, String p) {
//        // corner case
//        p = organizePatternStr(p);
//        if (p.equals("")) {
//            return s == null || s.equals("");
//        }
//        return matchByBackTracing(s.toCharArray(), 0, p.toCharArray(), 0);
//    }
//
//    boolean matchByBackTracing(char[] s, int si, char[] p, int pi) {
//        if (pi == p.length) {
//            return si == s.length;
//        }
//        if (pi == p.length - 1) {
//            if (si == s.length-1 && (p[pi] == s[si] || p[pi] == '.')) {
//                return true;
//            }
//            else {
//                return false;
//            }
//        }
//        if (p[pi+1] != '*'){
//            if (si >= s.length) return false;
//            return p[pi] == '.' || p[pi] == s[si] ? matchByBackTracing(s, ++si, p, ++pi) : false;
//        }
//        // '*' match for one time to more times abc .*d
//        while (si < s.length && (p[pi] == '.' || p[pi] == s[si])) {
//            if (matchByBackTracing(s, si, p, pi+2)) return true;
//            si++;
//        }
//        // '*' match 0 time
//        pi += 2;
//        return matchByBackTracing(s, si, p, pi);
//    }
//
//    /**
//     * remove duplicate star, for example, transfer "a***b" to "a*b"
//     *
//     * @param p pattern
//     */
//    public String organizePatternStr(String p) {
//        if (p == null || p.equals("")) {
//            return "";
//        }
//        // remove leading '*'
//        String tmp = p.charAt(0) == '*' ? "" : p;
//        if (tmp.equals("")) {
//            for (int i=0; i<p.length(); ++i) {
//                if (p.charAt(i) != '*') {
//                    tmp = p.substring(i);
//                    break;
//                }
//            }
//        }
//        // if p consist of one or more '*', return ""
//        if (tmp.equals("")) {
//            return "";
//        }
//        p = tmp;
//        // remove duplicate '*'
//        StringBuilder sb = new StringBuilder();
//        sb.append(p.charAt(0));
//        char[] chars = p.toCharArray();
//        for (int i=1; i<chars.length; ++i) {
//            if (chars[i] == '*' && chars[i-1] == '*') {
//                continue;
//            }
//            sb.append(chars[i]);
//        }
//        return sb.toString();
//    }

    // backtracking + dynamic program
    public boolean isMatch(String s, String p) {
        if (p == null || p.length() == 0) {
            return s == null || s.length() == 0;
        }
        while (!p.equals("")) {
            if (p.length() == 1) {
                return s.length() == 1 && (s.equals(p) || p.equals("."));
            } else if (p.charAt(1) == '*') {
                if (isMatch(s, p.substring(2))) {
                    return true;
                } else {
                    while (!s.equals("") && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                        if (isMatch(s = s.substring(1), p.substring(2))) {
                            return true;
                        }
                    }
                    return false;
                }
            } else {
                if (!s.equals("") && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                    s = s.substring(1);
                    p = p.substring(1);
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    // state machine

    public static void main(String[] args) {
        LeetCode10 l = new LeetCode10();
//        System.out.println(l.isMatch("aab", "a*b")); // true
//        System.out.println(l.isMatch("aa", "a")); // false
//        System.out.println(l.isMatch("aa", "a*")); // true
//        System.out.println(l.isMatch("ab", ".*")); // true
//        System.out.println(l.isMatch("ab", ".*c")); // false
//        System.out.println(l.isMatch("aab", "c*a*b")); // true
//        System.out.println(l.isMatch("mississippi", "mis*is*p")); // false
//        System.out.println(l.isMatch("", "a*b*")); // true
//        System.out.println(l.isMatch("a", ".*..a*")); // false
//        System.out.println(l.isMatch("aaaaaaaaaaaaab","a*a*a*a*a*a*a*a*a*a*c")); // false
//        System.out.println(l.isMatch("abbaaaabaabbcba","a*.*ba.*c*..a*.a*.")); // false
//        System.out.println(l.isMatch("aaa","ab*ac*a")); // true
        System.out.println(l.isMatch("abcdede","ab.*de")); // true
    }
}

