/**
 * @author hanxin
 * @date 2022/3/24 22:52
 */
public class LeetCode4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            if (nums1 == null && nums2 == null) {
                return 0.0;
            }
            else {
                return nums1 == null ? (nums2[nums2.length - 1] + nums2[nums2.length])/2 : (nums1[nums1.length - 1] + nums1[nums1.length])/2;
            }
        }
        int sumLength = nums1.length + nums2.length;
        if ((sumLength & 1) == 0) {
            return (findKth(nums1, 0, nums2, 0, sumLength/2) + findKth(nums1, 0, nums2, 0, sumLength/2 + 1))/2;
        }
        else {
            return findKth(nums1, 0, nums2, 0, sumLength/2 + 1);
        }
    }

    public double findKth(int[] nums1, int left1, int[] nums2, int left2, int k) {
        if (left1 >= nums1.length) {
            return nums2[left2 + k - 1];
        }
        else if (left2 >= nums2.length) {
            return nums1[left1 + k - 1];
        }
        if (k == 1) {
            return nums1[left1] > nums2[left2] ? nums2[left2] : nums1[left1];
        }
        int mid1 = left1 + k/2 - 1 >= nums1.length ? Integer.MAX_VALUE : nums1[left1 + k/2 - 1];
        int mid2 = left2 + k/2 - 1 >= nums2.length ? Integer.MAX_VALUE : nums2[left2 + k/2 - 1];
        return mid1 > mid2 ? findKth(nums1, left1, nums2, left2 + k/2, k - k/2) : findKth(nums1, left1 + k/2, nums2, left2, k - k/2);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        Double res = new LeetCode4().findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}


