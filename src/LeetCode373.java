import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode373 {

    // 二分查找 todo
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return res;
        }
        return res;
    }

    // 多路归并
    // M为m，n，k三者中的最小值，时间复杂度O((M+K)*logn)，空间复杂度O(M)
//    boolean isExchange = false;
//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
//            return res;
//        }
//        // 确保nums1一定比nums2小
//        if (nums1.length > nums2.length) {
//            isExchange = true;
//            return kSmallestPairs(nums2, nums1, k);
//        }
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> ((nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])));
//        for (int  i = 0; i < Math.min(nums1.length, k); i++) {
//            pq.offer(new int[]{i, 0});
//        }
//        while (res.size() < k && !pq.isEmpty()) {
//            int[] pair = pq.poll();
//            res.add(isExchange ? Arrays.asList(nums2[pair[1]], nums1[pair[0]]) : Arrays.asList(nums1[pair[0]], nums2[pair[1]]));
//            // 补充一个候选值
//            if (pair[1] + 1 < nums2.length) {
//                pq.offer(new int[]{pair[0], pair[1] + 1});
//            }
//        }
//        // 执行完还原
//        isExchange = false;
//        return res;
//    }


    public static void main(String[] args) {
        LeetCode373 l = new LeetCode373();
        System.out.println(l.kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3)); // [1,2],[1,4],[1,6]
        System.out.println(l.kSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 2)); // [1,1],[1,1]
        System.out.println(l.kSmallestPairs(new int[]{1,2}, new int[]{3}, 3)); // [1,3],[2,3]
        System.out.println(l.kSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 10)); // [1,1],[1,1],[2,1],[1,2],[1,2],[2,2],[1,3],[1,3],[2,3]

    }

}
