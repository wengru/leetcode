/**
 * @author hanxin
 * @date 2022/3/24 23:06
 */
public class LeetCode14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (String str : strs) {
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        LeetCode14 l = new LeetCode14();
        System.out.println(l.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(l.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

}