import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode300 {

    // dynamic
//    public int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int res = 1;
//        int[] dp = new int[nums.length];
//        for (int i=0; i<nums.length; ++i) {
//            dp[i] = 1;
//            for (int j=0; j<i; ++j) {
//                if (nums[i] > nums[j]) {
//                    res = Math.max(res, dp[i] = Math.max(dp[j]+1, dp[i]));
//                }
//            }
//        }
//        return res;
//    }

    //  dynamic + binary search
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] cell = new int[nums.length];
        int lastIdx = 0;
        // 数组中第k个位置的元素表示长度为k+1的子串的尾部元素值
        cell[0] = nums[0];
        for (int i=1; i<nums.length; ++i) {
            if (nums[i] > cell[lastIdx]) {
                cell[++lastIdx] = nums[i];
            } else {
                int l = 0, r = lastIdx;
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (cell[mid] < nums[i]) {
                        l = mid+1;
                    } else {
                        r = mid;
                    }
                }
                cell[l] = nums[i];
            }
        }
        return lastIdx + 1;
    }

    // stack: error
//    public int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        Deque<Integer> deque = new ArrayDeque<>();
//        for (int i=0; i<nums.length; ++i) {
//            if (deque.isEmpty() || deque.peek() < nums[i]) {
//                deque.push(nums[i]);
//            } else {
//                while (!deque.isEmpty() && deque.peek() >= nums[i]) {
//                    deque.pop();
//                }
//                deque.push(nums[i]);
//            }
//        }
//        return deque.size();
//    }

    public static void main(String[] args) {
        LeetCode300 l = new LeetCode300();
        System.out.println(l.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18})); // 4
        System.out.println(l.lengthOfLIS(new int[]{0,1,0,3,2,3})); // 4
        System.out.println(l.lengthOfLIS(new int[]{7,7,7,7,7,7,7})); // 1
    }

}
