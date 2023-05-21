import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode368 {

    // 动态规划，时间复杂度O(n^2)，空间复杂度O(n)
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // record[n][0]是当前位置最大长度，record[n][1]是最大长度的前一个元素坐标
        int[][] record = new int[nums.length][2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]%nums[j] == 0 && record[j][0] + 1 > record[i][0]) {
                    record[i][0] = record[j][0] + 1;
                    record[i][1] = j;
                }
            }
        }
        // 找出最大的长度的最后一个元素
        int maxIdx = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (record[i][0] > maxLen) {
                maxLen = record[i][0];
                maxIdx = i;
            }
        }
        // 根据索引从后往前找，生成结果集
        while (maxLen-- > -1) {
            res.add(nums[maxIdx]);
            maxIdx = record[maxIdx][1];
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode368 l = new LeetCode368();
        System.out.println(l.largestDivisibleSubset(new int[]{1,2,3})); // [1,2] or [1,3]
        System.out.println(l.largestDivisibleSubset(new int[]{1,2,4,8})); // [1,2,4,8]
    }
}
