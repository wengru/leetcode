import java.math.BigDecimal;
import java.util.*;

public class LeetCode20 {

    public boolean isValid(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        Deque<Character> deque = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                deque.push(c);
            } else {
                if (deque.isEmpty() || !map.get(deque.pop()).equals(c)) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode20 l = new LeetCode20();
        System.out.println(l.isValid("()")); // true
        System.out.println(l.isValid("()[]{}")); // true
        System.out.println(l.isValid("(]")); // false
        System.out.println(l.isValid("([)]")); // false
        System.out.println(l.isValid("{[]}")); // true
    }

}
