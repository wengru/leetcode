public class LeetCode221 {

    /**
     * 动态规划，只需要一趟遍历找出最大值，时间复杂度O(m*n)，空间复杂度O(m*n)
     */
//    public int maximalSquare(char[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return 0;
//        }
//        int[][] dp = new int[matrix.length][matrix[0].length];
//        int res = 0;
//        for (int i=0; i<matrix.length; ++i) {
//            for (int j=0; j<matrix[i].length; ++j) {
//                if (i != 0 && j != 0) {
//                    dp[i][j] = matrix[i][j] == '0' ? 0 : Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
//                } else {
//                    dp[i][j] = matrix[i][j] == '0' ? 0 : 1;
//                }
//                res = Math.max(res, dp[i][j]);
//            }
//        }
//        return res*res;
//    }

    /**
     * 动态规划，只需要一趟遍历找出最大值，
     * 可以不用构建一个同等大小的int[][]，因为每个位置的最大大小仅与它左边和它右边的最大大小有关，
     * 因此时间复杂度为O(m*n)(假设matrix长宽分别为m和n)，额外空间复杂度为O(m)
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[2][matrix[0].length];
        int res = 0, last = 0, temp = 0;
        for (int i=0; i<matrix.length; ++i) {
            for (int j=0; j<matrix[i].length; ++j) {
                if (i != 0 && j != 0) {
                    temp = dp[last^1][j] = matrix[i][j] == '0' ? 0 : Math.min(dp[last][j], Math.min(dp[last^1][j-1], dp[last][j-1])) + 1;
                } else {
                    temp = dp[i == 0 ? last : last^1][j] = matrix[i][j] == '0' ? 0 : 1;
                }
                res = Math.max(res, temp);
            }
            last = i > 0 ? last^1 : last;
        }
        return res*res;
    }

    public static void main(String[] args) {
        LeetCode221 l = new LeetCode221();
        System.out.println(l.maximalSquare(
                new char[][]{
                        new char[]{'1','0','1','0','0'},
                        new char[]{'1','0','1','1','1'},
                        new char[]{'1','1','1','1','1'},
                        new char[]{'1','0','0','1','0'}
                }
        )); // 4
        System.out.println(l.maximalSquare(
                new char[][]{
                        new char[]{'0', '1'},
                        new char[]{'1', '0'}
                }
        )); // 1
        System.out.println(l.maximalSquare(
                new char[][]{
                        new char[]{'0'}
                }
        )); // 0
        System.out.println(l.maximalSquare(
                new char[][]{
                        new char[]{'1','0','1','0'},
                        new char[]{'1','0','1','1'},
                        new char[]{'1','0','1','1'},
                        new char[]{'1','1','1','1'}
                }
        )); // 4
        System.out.println(l.maximalSquare(
                new char[][]{
                        new char[]{'1'}
                }
        )); // 0
    }

}
