import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode56 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (o1,o2) -> o1[0] - o2[0]);
        int[] tempArr = intervals[0];
        for (int i=1; i<intervals.length; ++i) {
            if (tempArr[1] < intervals[i][0]) {
                list.add(tempArr);
                tempArr = intervals[i];
            } else {
                tempArr[1] = Math.max(intervals[i][1], tempArr[1]);
            }
        }
        list.add(tempArr);
        int[][] res = new int[list.size()][2];
        for (int i=0; i<list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode56 l = new LeetCode56();
//        l.merge()
    }

}
