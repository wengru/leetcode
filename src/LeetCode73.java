public class LeetCode73 {


    // using hashmap, space:O(m+n)
//    public void setZeroes(int[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return;
//        }
//        int[] rowCount = new int[matrix.length];
//        int[] columnCount = new int[matrix[0].length];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == 0) {
//                    rowCount[i] = 1;
//                    columnCount[j] = 1;
//                }
//            }
//        }
//        for (int i=0; i<matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (rowCount[i] == 1 || columnCount[j] == 1) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//        return;
//    }

    // 空间O(1)解法
    public void setZeroes(int[][] matrix) {
        int rowFlag = 0, columnFlag = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0 || matrix[0].length == 1) {
                        rowFlag = 1;
                    }
                    if (j == 0 || matrix.length == 1) {
                        columnFlag = 1;
                    }
                }
            }
        }
        // 先处理内层
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 处理外层列
        if (columnFlag == 1) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        // 处理外层行
        if (rowFlag == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode73 l = new LeetCode73();
//        int[][] case1 = new int[][]{
//                new int[]{1,1,1},
//                new int[]{1,0,1},
//                new int[]{1,1,1}
//        };
//        l.setZeroes(case1); // [[1,0,1],[0,0,0],[1,0,1]]
//        TestUtil.printArray(case1);
//        int[][] case2 = new int[][]{
//                new int[]{0,1,2,0},
//                new int[]{3,4,5,2},
//                new int[]{1,3,1,5}
//        };
//        l.setZeroes(case2); // [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
        int[][] case3 = new int[][]{
                new int[]{1,2,3,4},
                new int[]{5,0,7,8},
                new int[]{0,10,11,12},
                new int[]{13,14,15,0}
        };
        l.setZeroes(case3); // [[0,0,3,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]
        TestUtil.printArray(case3);
    }

}
