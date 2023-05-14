import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.stream.Collectors;

public class LeetCode402 {

    public String removeKdigits(String num, int k) {
        if (num == null || num.equals("") || num.length() <= k) {
            return "0";
        }
        Deque<Character> deque = new ArrayDeque<>();
        // 如果已经移除k个了，剩下的就是答案
        // 如果栈里已经有n-k个元素了，栈里的就是答案
        // num乱序，不遍历到最后一个元素无法确定最终答案
        int n = k, i = 0;
        while (i < num.length()) {
            if (deque.isEmpty() || num.charAt(i) - deque.getLast() >= 0) {
                deque.offer(num.charAt(i++));
            } else {
                if (--n == -1) {
                    break;
                }
                deque.pollLast();
            }
        }
        String res = deque.stream().map(Objects::toString).collect(Collectors.joining());
        res = (deque.size() > num.length() - k ? res.substring(0, num.length() - k) : res + (deque.size() == num.length() - k ? "" : num.substring(i))).replaceAll("^0+", "");
        return res.isEmpty() ? "0" : res;
    }

    public static void main(String[] args) {
        LeetCode402 l = new LeetCode402();
        System.out.println(l.removeKdigits("1432219", 3)); // "1219"
        System.out.println(l.removeKdigits("10200", 1)); // "200"
        System.out.println(l.removeKdigits("10", 1)); // "0"
        System.out.println(l.removeKdigits("112", 1)); // "11"
        System.out.println(l.removeKdigits("10001", 1)); // 1
        System.out.println(l.removeKdigits("10001", 4)); // 0
        System.out.println(l.removeKdigits("1234567890", 9)); // 0
        System.out.println(l.removeKdigits("1783760502568351612001027050", 1)); // 173760502568351612001027050
    }

}
