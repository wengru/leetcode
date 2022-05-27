import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hanxin
 * @date 2022/5/28 0:08
 */
public class LeetCode151 {

    // stack
    /*public String reverseWords(String s) {
        Deque deque = new ArrayDeque();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (' ' == c) {
                if (sb.length() > 0) {
                    deque.push(sb.toString());
                }
                sb.delete(0, sb.length());
                continue;
            }
            sb.append(c);
        }
        if (sb.length() > 0) {
            deque.push(sb.toString());
        }
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.append(deque.pop() + " ");
        }
        return res.length() == 0 ? res.toString() : res.substring(0, res.length() - 1);
    }*/

    // 双指针优化版，空间复杂度O(n)，时间复杂度O(n)
    // 先过滤无效空格，在翻转整个字符串，在翻转单词
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        // 过滤无效空格;
        s = s.trim();
        int preIdx = 0, idx = s.length()-1;
        // 翻转字符串
        char[] chars = new char[s.length() + 1];
        while (idx >= 0) { // StringBuilder.reverse
            chars[chars.length - 2 - idx] = s.charAt(idx);
            idx--;
        }
        chars[chars.length - 1] = ' ';
        idx++;
        StringBuilder res = new StringBuilder(); // byte as -> sa etyb
        // 翻转单词+过滤无效空格
        while (idx != chars.length) {
            if (chars[idx] == ' ' && chars[idx - 1] != ' ') {
                preIdx = idx - 1;
                while (preIdx >= 0 && chars[preIdx] != ' ') {
                    res.append(chars[preIdx--]);
                }
                res.append(" ");
            }
            idx++;
        }
        return res.substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
        LeetCode151 l = new LeetCode151();
        System.out.println(l.reverseWords("the sky is blue")); // "blue is sky the"
        System.out.println(l.reverseWords("  hello world  ")); // "world hello"
        System.out.println(l.reverseWords("a good   example")); // "example good a"
    }
}
