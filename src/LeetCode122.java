public class LeetCode122 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int i=1; i<prices.length; i++) {
            sum += prices[i] > prices[i-1] ? prices[i] - prices[i-1] : 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode122 l = new LeetCode122();
        System.out.println(l.maxProfit(new int[]{7,1,5,3,6,4})); // 7
        System.out.println(l.maxProfit(new int[]{1,2,3,4,5})); // 4
        System.out.println(l.maxProfit(new int[]{7,6,4,3,1})); // 0
    }

}
