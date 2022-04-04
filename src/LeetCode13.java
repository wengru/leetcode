import java.util.HashMap;
import java.util.Map;

/**
 * @author hanxin
 * @date 2022/3/24 23:05
 */
public class LeetCode13 {

    public int romanToInt(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10); //
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        int preNum = map.get(s.charAt(0));
        for (int i=1; i<s.length(); ++i) {
            if (map.get(s.charAt(i)) > preNum) {
                res -= preNum;
            }
            else {
                res += preNum;
            }
            preNum = map.get(s.charAt(i));
        }
        res += map.get(s.charAt(s.length()-1));
        return res;
    }

    public static void main(String[] args) {
        LeetCode13 l = new LeetCode13();
        System.out.println(l.romanToInt("IV")); // 4
        System.out.println(l.romanToInt("IX")); // 9
        System.out.println(l.romanToInt("LVIII")); // 58
        System.out.println(l.romanToInt("MCMXCIV")); // 1994
    }

}