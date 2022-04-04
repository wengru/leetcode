import java.util.HashMap;
import java.util.Map;

/**
 * @author hanxin
 * @date 2022/3/24 23:22
 */
public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, lIndex = 0, rIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(rIndex < s.length()) {
            if (map.get(s.charAt(rIndex)) == null) {
                map.put(s.charAt(rIndex), 1);
                maxLength = maxLength > (rIndex-lIndex+1) ? maxLength : (rIndex-lIndex+1);
                rIndex++;
            }
            else {
                map.remove(s.charAt(lIndex));
                lIndex++;
            }
        }
        return maxLength;
    }

}