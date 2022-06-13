import java.util.Arrays;
import java.util.List;

public class LeetCode139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        return false;
    }

    public static void main(String[] args) {
        LeetCode139 l = new LeetCode139();
        System.out.println(l.wordBreak("leetcode", Arrays.asList("leet","code"))); // true
        System.out.println(l.wordBreak("applepenapple", Arrays.asList("apple","pen"))); // true
        System.out.println(l.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat"))); // false
    }

}
