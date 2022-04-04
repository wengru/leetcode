/**
 * @author hanxin
 * @date 2022/3/24 23:05
 */
public class LeetCode12 {

    public String intToRoman(int num) {
        String[] one = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] two = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] three = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] four = {"", "M", "MM", "MMM"};
        return four[num/1000] + three[num%1000/100] + two[num%100/10] + one[num%10];
    }

}