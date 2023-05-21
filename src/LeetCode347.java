import java.util.*;

public class LeetCode347 {

    // 堆排序，时间复杂度O(nlogn)
//    public int[] topKFrequent(int[] nums, int k) {
//        int[] res = new int[k];
//        if (nums == null || nums.length == 0) {
//            return res;
//        }
//        Map<Integer, Integer> map = new HashMap<>();
//        // 先统计频率
//        for (int n : nums) {
//            int count = map.getOrDefault(n, 0);
//            map.put(n, count + 1);
//        }
//        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return o2.getValue() - o1.getValue();
//            }
//        });
//        for (Map.Entry entry : map.entrySet()) {
//            queue.add(entry);
//        }
//        while (k-- > 0) {
//            res[k%res.length] = queue.poll().getKey();
//        }
//        return res;
//    }

    // 桶排序
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        // 先统计频率
        for (int n : nums) {
            int count = map.getOrDefault(n, 0);
            map.put(n, count + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        for (Integer key : map.keySet()) {
            bucket[map.get(key)].add(key);
        }
        for (int i = bucket.length - 1; i >= 0 && k > 0; i--) {
            if (bucket[i].size() != 0) {
                for (Integer n : bucket[i]) {
                    res[--k] = n;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode347 l = new LeetCode347();
        TestUtil.printArray(l.topKFrequent(new int[]{1,1,1,2,2,3}, 2)); // [1,2]
        TestUtil.printArray(l.topKFrequent(new int[]{1}, 1)); // [1]
        TestUtil.printArray(l.topKFrequent(new int[]{-1, -1}, 1)); // [-1]
        TestUtil.printArray(l.topKFrequent(new int[]{1, 2}, 2)); // [1,2]
        TestUtil.printArray(l.topKFrequent(new int[]{5,3,1,1,1,3,73,1}, 2)); // [1,3]
    }

}
