import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int height = matrix.length, width = matrix[0].length;
        while (height > 0 && width > 0) {
            int x1 = (matrix[0].length - width)/2, y1 = (matrix.length - height)/2;
            int x2 = x1 + width - 1, y2 = y1 + height - 1;
            if (y1 == y2) {
                for (int i=x1; i<=x2; ++i) {
                    res.add(matrix[y1][i]);
                }
            } else if (x1 == x2) {
                for (int i=y1; i<=y2; ++i) {
                    res.add(matrix[i][x2]);
                }
            }
            // 向右
            for (int i = x1; i<x2 && y1 < y2; ++i) {
                res.add(matrix[y1][i]);
            }
            // 向下
            for (int i=y1; i<y2 && x1 < x2; ++i) {
                res.add(matrix[i][x2]);
            }
            // 向左
            for (int i=x2; i>x1 && y1 < y2; --i) {
                res.add(matrix[y2][i]);
            }
            // 向上
            for (int i=y2; i>y1 && x1 < x2; --i) {
                res.add(matrix[i][x1]);
            }
            height -= 2;
            width -= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode54 l = new LeetCode54();
//        System.out.println(l.spiralOrder(new int[][]{
//                new int[]{1,2,3,4},
//                new int[]{5,6,7,8},
//                new int[]{9,10,11,12}
//        })); // [1,2,3,4,8,12,11,10,9,5,6,7]
//        System.out.println(l.spiralOrder(new int[][]{
//                new int[]{1,2,3},
//                new int[]{4,5,6},
//                new int[]{7,8,9}
//        })); // [1,2,3,6,9,8,7,4,5]
//        System.out.println(l.spiralOrder(new int[][]{
//                new int[]{1,2,3}
//        })); // [1,2,3]
        System.out.println(l.spiralOrder(new int[][]{
                new int[]{3},
                new int[]{2}
        })); // [3,2]
//        System.out.println(l.spiralOrder(new int[][]{
//                new int[]{3}
//        })); // [3]
    }

}
