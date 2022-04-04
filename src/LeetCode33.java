public class LeetCode33 {

    public int search2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length-1, mid;
        while (left < right) {
            mid = (left + right + 1) >> 1;
            if (nums[mid] < nums[0]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return nums[left == nums.length-1 ? 0 : left+1];
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = nums.length-1, mid;
        // 先找到旋转点nums[k]，再去做二分
        while (left < right) {
            mid = (left + right + 1) >> 1;
            if (nums[mid] < nums[0]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // nums[left]是分割点，判断在nums[left]左边做二分查还是右边做二分查
        if (nums[0] < target) {
            left = 0;
        } else if (nums[0] > target) {
            left = left + 1;
            right = nums.length-1;
        } else {
            return 0;
        }
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        return nums[right] == target ? left : -1;
    }

    public static void main(String[] args) {
        LeetCode33 l = new LeetCode33();
        System.out.println(l.search2(new int[]{4,5,6,7,0,1,2}));
        System.out.println(l.search2(new int[]{1}));
        System.out.println(l.search2(new int[]{3,1}));
        System.out.println(l.search2(new int[]{1,3,5}));
        System.out.println(l.search2(new int[]{3,1,3,3}));
//        System.out.println(l.search(new int[]{4,5,6,7,0,1,2}, 0)); // 4
//        System.out.println(l.search(new int[]{4,5,6,7,0,1,2}, 3)); // -1
//        System.out.println(l.search(new int[]{1}, 0)); // -1
//        System.out.println(l.search(new int[]{3,1}, 1)); // 1
//        System.out.println(l.search(new int[]{1,3,5}, 5)); // 2
//        System.out.println(l.search(new int[]{1,3}, 0)); // -1
    }

}
