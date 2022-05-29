public class LeetCode189 {

    public void rotate(int[] nums, int k) {
        if (k <= 0) {
            return;
        }
    }

    public static void main(String[] args) {
        LeetCode189 l = new LeetCode189();
        l.rotate(new int[]{1,2,3,4,5,6,7}, 3); // [5,6,7,1,2,3,4]
        l.rotate(new int[]{-1,-100,3,99}, 2); // [3,99,-1,-100]
    }

}
