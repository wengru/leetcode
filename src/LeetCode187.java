import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode187 {

    // 直接用哈希
//    public List<String> findRepeatedDnaSequences(String s) {
//        List<String> res = new ArrayList<>();
//        if (s == null || s.length() < 10) {
//            return res;
//        }
//        Map<String, Integer> sequenceMap = new HashMap<>();
//        int c = 0;
//        for (int i = 10; i <= s.length(); i++) {
//            String seq = s.substring(i - 10, i);
//            int count = sequenceMap.getOrDefault(seq, c);
//            if (count == 1) {
//                res.add(seq);
//            }
//            sequenceMap.put(seq, count + 1);
//        }
//        return res;
//    }

    // 前缀和+滚动哈希+位运算
    // 使用两个二进制位表示字符，用于实现滚动哈希使用Integer作为key，并通过滚动的形式在O(1)时间内求出哈希
    // 20个比特位表示长度为10的子序列，用int实现
    // A: 00
    // C: 01
    // G: 10
    // T: 11
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return res;
        }
        int[] nums = new int[20];
        nums['A' - 'A'] = 0;
        nums['C' - 'A'] = 1;
        nums['G' - 'A'] = 2;
        nums['T' - 'A'] = 3;
        int len = 10, hash = 0, h = (1 << 20) - 1;
        for (int i = 0; i < len; i++) {
            hash = (hash << 2) | nums[s.charAt(i) - 'A'];
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        Integer tempCount = 0;
        countMap.put(hash, 1);
        for (int i = len; i < s.length(); i++) {
            hash = ((hash << 2) | nums[s.charAt(i) - 'A']) & h;
            Integer count = countMap.getOrDefault(hash, tempCount);
            countMap.put(hash, count + 1);
            if (count == 1) {
                res.add(s.substring(i - len + 1, i + 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode187 l = new LeetCode187();
        System.out.println(l.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")); //["AAAAACCCCC","CCCCCAAAAA"]
        System.out.println(l.findRepeatedDnaSequences("AAAAAAAAAAAAA")); // ["AAAAAAAAAA"]
        System.out.println(l.findRepeatedDnaSequences("AAAAAAAAAAA")); // ["AAAAAAAAAA"]
    }

}
