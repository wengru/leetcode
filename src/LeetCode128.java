import java.util.HashMap;
import java.util.Map;

public class LeetCode128 {

    // 朴素哈希
    // 把寻找长度的任务交给同一序列中最小的元素
//    public int longestConsecutive(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int result = 1;
//        Map<Integer, Object> parentMap = new HashMap<>();
//        for (int i=0; i<nums.length; i++) {
//            parentMap.put(nums[i], new Object());
//        }
//        for (int i=0; i<nums.length; i++) {
//            if (!parentMap.containsKey(nums[i]-1)) {
//                int count = 0;
//                while (parentMap.containsKey(nums[i]+(++count)));
//                result = result > count ? result : count;
//            }
//        }
//        return result;
//    }

    // 改良版哈希，与朴素哈希相同，哈希表value记录的是右边界
    // ...

    // 动态规划
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int result = 1;
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = map.getOrDefault(n - 1, 0);
                int right = map.getOrDefault(n + 1, 0);
                int length = left + right + 1;
                result = Math.max(length, result);
                map.put(n, -1);
                map.put(n - left, length);
                map.put(n + right, length);
            }
        }
        return result;
    }

//    private Map<Integer, Integer> parents;
//
//    private Map<Integer, Integer> rank;
//
//    // 以key为根节点下的节点的数量
//    private Map<Integer, Integer> count;
//
//    public void init(int[] nums) {
//        parents = new HashMap<>();
//        rank = new HashMap<>();
//        count = new HashMap<>();
//        for (int n : nums) {
//            parents.put(n, n);
//            rank.put(n, 0);
//            count.put(n, 1);
//        }
//    }
//
//    public int find(int n) {
//        // 并查集核心代码
//        if (parents.get(n) == n) {
//            return n;
//        } else {
//            parents.put(n, find(parents.get(n)));
//            return parents.get(n);
//        }
//    }
//
//    // 按秩合并，秩小的树作为子树合并到秩大的树里面
//    public int union(int x, int y) {
//        int rootx = find(x);
//        int rooty = find(y);
//        if (rootx != rooty) {
//            if (rank.get(rootx) < rank.get(rooty)) {
//                parents.put(rootx, rooty);
//            } else if (rank.get(rootx) > rank.get(rooty)) {
//                parents.put(rooty, rootx);
//            } else {
//                parents.put(rootx, rooty);
//                rank.put(rooty, rank.get(rootx) + 1);
//            }
//            count.put(rank.get(rootx) > rank.get(rooty) ? rootx : rooty, count.get(rootx) + count.get(rooty));
//        }
//        return count.get(rank.get(rootx) > rank.get(rooty) ? rootx : rooty);
//    }
//
//    // 并查集
//    public int longestConsecutive(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int result = 1;
//        init(nums);
//        // key是当前节点，value是父节点
//        // 向左合并
//        for (int n : nums) {
//            if (parents.containsKey(n - 1)) {
//                int k = union(n - 1, n);
//                result = Math.max(result, union(n - 1, n));
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        LeetCode128 l = new LeetCode128();
        System.out.println(l.longestConsecutive(new int[]{100,4,200,1,3,2})); // 4
        System.out.println(l.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1})); // 9
        System.out.println(l.longestConsecutive(new int[]{0})); // 1
    }

}
