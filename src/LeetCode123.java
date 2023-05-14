public class LeetCode123 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        LeetCode123 l = new LeetCode123();
        System.out.println(l.maxProfit(new int[]{3,3,5,0,0,3,1,4})); // 6
        System.out.println(l.maxProfit(new int[]{1,2,3,4,5})); // 4
        System.out.println(l.maxProfit(new int[]{7,6,4,3,1})); // 0
        System.out.println(l.maxProfit(new int[]{1})); // 0
    }

}
