import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return res;
        }
        String[] represents = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        findCombinations(digits, res, represents, "");
        return res;
    }

    public void findCombinations(String digits, List<String> res, String[] represents, String temp) {
        if (digits.equals("")) {
            res.add(temp);
            return;
        }
        for (char c : represents[digits.charAt(0) - '0'].toCharArray()) {
            findCombinations(digits.substring(1), res, represents, temp + c);
        }

    }

    public static void main(String[] args) {
        LeetCode17 l = new LeetCode17();
        System.out.println(l.letterCombinations("23")); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(l.letterCombinations("")); // []
        System.out.println(l.letterCombinations("2")); // ["a","b","c"]
    }

}
