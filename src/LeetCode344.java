import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode344 {

    // two pointer
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        for (int left = 0, right = s.length-1; left<right; left++, right--) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
        }
    }

    // using stack
//    public void reverseString(char[] s) {
//        if (s == null || s.length == 0) {
//            return;
//        }
//        Deque<Character> deque = new ArrayDeque<>();
//        for (char c : s) {
//            deque.push(c);
//        }
//        for (int i=0; i<s.length; ++i) {
//            s[i] = deque.pop();
//        }
//    }

    public static void main(String[] args) {
        LeetCode344 l = new LeetCode344();
        char[] c1 = new char[]{'h','e','l','l','o'};
        l.reverseString(c1);
        System.out.println(c1);
        char[] c2 = new char[]{'H','a','n','n','a','h'};
        l.reverseString(c2);
        System.out.println(c2);
    }

}
