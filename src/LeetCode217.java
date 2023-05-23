import java.util.HashMap;
import java.util.Map;

public class LeetCode217 {

    // 数组或者排序
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                return true;
            }
            map.put(n, 1);
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode217 l = new LeetCode217();
    }
}
