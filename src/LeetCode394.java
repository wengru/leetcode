import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode394 {

//    public String decodeString(String s) {
//        StringBuilder resStr = new StringBuilder();
//        int num = 0, i=0;
//        Deque<Character> stack = new ArrayDeque<>();
//        while (i<s.length()) {
//            while (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
//                num = num*10 + (s.charAt(i++) - '0');
//            }
//            if (num != 0) {
//                stack.push(s.charAt(i));
//                StringBuilder partStrBuilder = new StringBuilder();
//                partStrBuilder.append(s.charAt(i++));
//                while (!stack.isEmpty()) {
//                    if (s.charAt(i) == ']') {
//                        stack.pop();
//                    } else if (s.charAt(i) == '[') {
//                        stack.push('[');
//                    }
//                    partStrBuilder.append(s.charAt(i++));
//                }
//                String partStr = decodeString(partStrBuilder.toString());
//                for (int j=0; j<num; ++j) {
//                    resStr.append(partStr);
//                }
//                num = 0;
//            } else {
//                resStr.append(s.charAt(i) == ']' || s.charAt(i) == '[' ? "" : s.charAt(i));
//                i++;
//            }
//        }
//        return resStr.toString();
//    }

    // other thinking
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder(), partStrBuilder = new StringBuilder();
        int num = 0, count = 0;
        for (int i=0; i<s.length(); ++i) {
            if (s.charAt(i) == '[') {
                count++;
                partStrBuilder.append(s.charAt(i));
            } else if (s.charAt(i) == ']') {
                count--;
                partStrBuilder.append(']');
                if (count == 0) {
                    String partStr = decodeString(partStrBuilder.substring(1,partStrBuilder.length()-1));
                    partStrBuilder.delete(0, partStrBuilder.length());
                    for (; num > 0; num--) {
                        res.append(partStr);
                    }
                }
            } else if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <=9) {
                if (count == 0) {
                    num = num * 10 + (s.charAt(i) - '0');
                } else {
                    partStrBuilder.append(count == 0 ? "" : s.charAt(i));
                }
            } else if (count == 0) {
                res.append(s.charAt(i));
            } else {
                partStrBuilder.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LeetCode394 l = new LeetCode394();
//        System.out.println(l.decodeString("3[a]2[bc]")); // "aaabcbc"
        System.out.println(l.decodeString("3[a2[c]]")); // "accaccacc"
//        System.out.println(l.decodeString("2[abc]3[cd]ef")); // "abcabccdcdcdef"
//        System.out.println(l.decodeString("abc3[cd]xyz")); // "abccdcdcdxyz"
    }
}
