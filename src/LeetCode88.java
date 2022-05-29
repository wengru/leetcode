public class LeetCode88 {

    // 从后往前排
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n == 0) {
            return;
        }
        int idx1 = m - 1, idx2 = n - 1, idx = nums1.length - 1;
        // 直到两个数组中一个全部放到排序后对应的位置上
        while (idx1 >= 0 && idx2 >= 0) {
            nums1[idx--] = nums1[idx1] > nums2[idx2] ? nums1[idx1--] : nums2[idx2--];
        }
        // 如果此时还未完成排序，那待排序的元素只能存在nums2里面
        while (idx2 >= 0) {
            nums1[idx--] = nums2[idx2--];
        }
    }

    public static void main(String[] args) {
        LeetCode88 l = new LeetCode88();
        l.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3); // [1,2,2,3,5,6]
        l.merge(new int[]{1}, 1, new int[]{}, 0); // [1]
        l.merge(new int[]{0}, 0, new int[]{1}, 1); // [1]
        l.merge(new int[]{2,0}, 1, new int[]{1}, 1); // [1,2]
    }

}
