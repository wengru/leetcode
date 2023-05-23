public class LeetCode162 {

    // 二分查找，时间复杂度O(logn)
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1, mid;
        while (l < r) {
            mid = (l + r) >> 1;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        LeetCode162 l = new LeetCode162();
        System.out.println(l.findPeakElement(new int[]{1,2,3,1})); // 2
        System.out.println(l.findPeakElement(new int[]{1,2,1,3,5,6,4})); // 5
    }

}
