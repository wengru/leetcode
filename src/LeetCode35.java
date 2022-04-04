public class LeetCode35 {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 1, right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid+1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        return nums[--left] >= target ? left : ++left;
    }

    public static void main(String[] args) {
        LeetCode35 l = new LeetCode35();
        System.out.println(l.searchInsert(new int[]{1,3,5,6}, 5)); // 2
        System.out.println(l.searchInsert(new int[]{1,3,5,6}, 2)); // 1
        System.out.println(l.searchInsert(new int[]{1,3,5,6}, 7)); // 4
        System.out.println(l.searchInsert(new int[]{1,3,5,6}, 0)); // 0
        System.out.println(l.searchInsert(new int[]{1}, 0)); // 0
        System.out.println(l.searchInsert(new int[]{1}, 1)); // 0
    }

}
