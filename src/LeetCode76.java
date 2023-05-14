import java.util.HashSet;
import java.util.Set;

public class LeetCode76 {

    // 滑动窗口，s需要遍历2遍，t需要遍历一遍，时间复杂度O(m + n)
    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty() || t.length() > s.length()) {
            return "";
        }
        s = s + "{";
        int[] sCount = new int[60];
        int[] tCount = new int[60];
        // 使用set的长度优化校验是否包含字串的过程时间复杂度到常数
        Set<Character> needSet = new HashSet<>();
        for (char c : t.toCharArray()) {
            tCount[c - 'A']++;
            needSet.add(c);
        }
        int left = 0, right = 0, count = Integer.MAX_VALUE, resL = 0, resR = 0;
        while (right < s.length()) {
            // 没有覆盖到t
            if (needSet.size() != 0) {
                int idx = s.charAt(right) - 'A';
                if (tCount[idx] != 0) {
                    sCount[idx]++;
                    if (sCount[idx] == tCount[idx]) {
                        needSet.remove(s.charAt(right));
                    }
                }
                right++;
            } else {
                // 覆盖到t的前提下把字串压缩到最小
                while (needSet.size() == 0) {
                    int idx = s.charAt(left) - 'A';
                    if ((right - left) < count) {
                        count = right - left;
                        resL = left;
                        resR = right;
                    }
                    if (sCount[idx] != 0) {
                        sCount[idx]--;
                        if (sCount[idx] < tCount[idx]) {
                            needSet.add(s.charAt(left));
                        }
                    }
                    left++;
                }
            }
        }
        return s.substring(resL, resR);
    }

    public static void main(String[] args) {
        LeetCode76 l = new LeetCode76();
        System.out.println(l.minWindow("ADOBECODEBANC", "ABC")); // "BANC"
        System.out.println(l.minWindow("a", "a")); // "a"
        System.out.println(l.minWindow("a", "aa")); // ""
        System.out.println(l.minWindow("aa", "aa")); // "aa"
    }

}
