/**
 * @author hanxin
 * @date 2022/3/24 22:54
 */
public class LeetCode6 {

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows < 2) {
            return s;
        }
        //count:temp stringBuilder index, forward: -1:up,1:down;
        int count = -1, direct = 1;
        StringBuilder res = new StringBuilder();
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i=0; i<stringBuilders.length; ++i) {
            stringBuilders[i] = new StringBuilder();
        }
        for (char c : s.toCharArray()) {
            stringBuilders[count+=direct].append(c);
            if (count + direct < 0 || count + direct == numRows) {
                direct = -direct;
            }
        }
        for (StringBuilder stringBuilder : stringBuilders) {
            res.append(stringBuilder.toString());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode6().convert("PAYPALISHIRING", 1));
    }
}
