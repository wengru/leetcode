public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        int firstIdx = findPosition(nums, target, true);
        return firstIdx == -1 ? new int[]{-1, -1} : new int[]{firstIdx, findPosition(nums, target, false)};
    }

    int findPosition(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = isFirst ? (left + right) >> 1 : (left + right + 1) >> 1;
            if (nums[mid] < target) {
                left = mid+1;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                if (isFirst) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        LeetCode34 l = new LeetCode34();
        int[] a = l.searchRange(new int[]{5,7,7,8,8,10}, 8);
        System.out.println("[" + a[0] + "," + a[1] + "]"); // [3,4]
        int[] b = l.searchRange(new int[]{5,7,7,8,8,10}, 6);
        System.out.println("[" + b[0] + "," + b[1] + "]"); // [-1,-1]
        int[] c = l.searchRange(new int[]{}, 0);
        System.out.println("[" + c[0] + "," + c[1] + "]"); // [-1,-1]
    }

}
