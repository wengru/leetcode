import java.util.ArrayList;
import java.util.List;

public class LeetCode310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        return res;
    }

    public static void main(String[] args) {
        LeetCode310 l = new LeetCode310();
        l.findMinHeightTrees(
                4,
                new int[][]{
                        new int[]{1,0},
                        new int[]{1,2},
                        new int[]{1,3}
                }
        ); // [1]
        l.findMinHeightTrees(
                6,
                new int[][]{
                        new int[]{3,0},
                        new int[]{3,1},
                        new int[]{3,2},
                        new int[]{3,4},
                        new int[]{5,4}
                }
        ); // [3,4]
    }

}
