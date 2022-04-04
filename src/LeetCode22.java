import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper("", n, 0, res);
        return res;
    }

    public void helper(String s, int n, int count, List<String> list) {
        if (n > 0) {
            helper(s+"(", n-1, count+1, list);
            if (count > 0) {
                helper(s+")", n, count-1, list);
            }
        } else {
            for (int i=0; i<count; ++i) {
                s+=")";
            }
            list.add(s);
        }
    }

    public static void main(String[] args) {
        LeetCode22 l = new LeetCode22();
        System.out.println(l.generateParenthesis(3)); // ["((()))","(()())","(())()","()(())","()()()"]
        System.out.println(l.generateParenthesis(1)); // ["()"]
    }
}
