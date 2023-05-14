public class LeetCode347 {

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        return res;
    }

    public static void main(String[] args) {
        LeetCode347 l = new LeetCode347();
        TestUtil.printArray(l.topKFrequent(new int[]{1,1,1,2,2,3}, 2)); // [1,2]
        TestUtil.printArray(l.topKFrequent(new int[]{1}, 1)); // [1]
    }

}
