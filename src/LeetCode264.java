import java.util.*;

public class LeetCode264 {

    // 堆排序
    /*public int nthUglyNumber(int n) {
        if (n == 1) {
            return n;
        }
        int nums[] = new int[]{2, 3, 5};
        Set<Long> set = new HashSet<>();
        set.add(1L);
        Queue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        while (--n > 0) {
            Long cur = queue.poll();
            for (int num : nums) {
                Long next = cur*num;
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
        return queue.poll().intValue();
    }*/

    // 动态规划 三个指针
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int v2 = 1, v3 = 1, v5 = 1, idx2 = 1, idx3 = 1, idx5 = 1, idx = 2; idx < nums.length; idx++) {
            nums[idx] = Math.min(Math.min(v2 = nums[idx2]*2, v3 = nums[idx3]*3), v5 = nums[idx5]*5);
            if (v2 == nums[idx]) {
                idx2++;
            }
            if (v3 == nums[idx]) {
                idx3++;
            }
            if (v5 == nums[idx]) {
                idx5++;
            }
        }
        return nums[n];
    }

    public static void main(String[] args) {
        LeetCode264 l = new LeetCode264();
        System.out.println(l.nthUglyNumber(10)); // 12
        System.out.println(l.nthUglyNumber(1)); // 1
    }

}
