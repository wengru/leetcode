import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode215 {

    // heap, time complexity O(n), space complexity O(n)
//    public int findKthLargest(int[] nums, int k) {
//        if (nums == null || nums.length == 0 || k <=0 || k >= nums.length) {
//            return Integer.MIN_VALUE;
//        }
//        Queue<Integer> queue = new PriorityQueue<>();
//        for (int i=0; i<nums.length; ++i) {
//            queue.add(nums[i]);
//        }
//        for (int i=0; i<nums.length-k; ++i) {
//            queue.poll();
//        }
//        return queue.peek();
//    }

    // divide and conquer + priority queue, time complexity O(n), space complexity O(1)
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <=0 || k > nums.length) {
            return Integer.MIN_VALUE;
        }
        int left = 0, right = nums.length-1, pos = nums.length-k;
        while (left <= right) {
            int idx= partition(nums, left, right);
            if (idx == pos) {
                return nums[idx];
            } else if (idx < pos) {
                left = idx+1;
            } else {
                right = idx-1;
            }
        }
        return nums[left];
    }

    int partition(int[] nums, int left, int right) {
        int startIdx = left;
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] > pivot) {
                right--;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, startIdx, left);
        return left;
    }

    void swap(int[] nums, int left, int right) {
        int n = nums[left];
        nums[left] = nums[right];
        nums[right] = n;
    }

    public static void main(String[] args) {
        LeetCode215 l = new LeetCode215();
        System.out.println(l.findKthLargest(new int[]{3,2,1,5,6,4}, 2)); // 5
        System.out.println(l.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4)); // 4
    }

}
