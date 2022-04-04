public class LeetCode63 {

    /**
     * dynamic program
     */
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
//            return 0;
//        }
//        int m = obstacleGrid.length-1, n = obstacleGrid[m].length-1;
//        if (obstacleGrid[m][n] == 1) {
//            return 0;
//        }
//        for (int i=0; i<obstacleGrid.length; ++i) {
//            for (int j=0; j<obstacleGrid[i].length; ++j) {
//                // obstacle
//                if (obstacleGrid[i][j] == 1) {
//                    obstacleGrid[i][j] = -1;
//                } else {
//                    if (i != 0 && j != 0) {
//                        obstacleGrid[i][j] = (obstacleGrid[i-1][j] == -1 ? 0 : obstacleGrid[i-1][j]) + (obstacleGrid[i][j-1] == -1 ? 0 : obstacleGrid[i][j-1]);
//                    } else if (i == 0 && j == 0) {
//                        obstacleGrid[i][j] = 1;
//                    } else {
//                        obstacleGrid[i][j] = i == 0 ? (obstacleGrid[i][j-1] == -1 ? 0 : obstacleGrid[i][j-1]) : (obstacleGrid[i-1][j] == -1 ? 0 : obstacleGrid[i-1][j]);
//                    }
//                }
//            }
//        }
//        return obstacleGrid[m][n];
//    }

    /**
     * dfs
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        return dfs(obstacleGrid, obstacleGrid.length-1, obstacleGrid[0].length-1);
    }

    /**
     * dfs is faster than dynamic program, but time limited exceed
     * @param obstacleGrid
     * @param m row  ——
     * @param n column  |
     * @return
     */
    public int dfs(int[][] obstacleGrid, int m, int n) {
        if (obstacleGrid[m][n] == 1) {
            return 0;
        } else {
            if (m != 0 && n != 0) {
                return dfs(obstacleGrid, m-1, n) + dfs(obstacleGrid, m, n-1);
            } else if (m == 0 && n == 0) {
                return 1;
            } else {
                return m == 0 ? dfs(obstacleGrid, m, n-1) : dfs(obstacleGrid, m-1, n);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode63 l = new LeetCode63();
//        System.out.println(l.uniquePathsWithObstacles(new int[][]{
//                new int[]{0,0,0},
//                new int[]{0,1,0},
//                new int[]{0,0,0}
//        })); // 2
//        System.out.println(l.uniquePathsWithObstacles(new int[][]{
//                new int[]{0,1},
//                new int[]{0,0}
//        })); // 1
//        System.out.println(l.uniquePathsWithObstacles(new int[][]{
//                new int[]{0,0},
//                new int[]{0,1}
//        })); // 0
        System.out.println(l.uniquePathsWithObstacles(new int[][]{
                new int[]{0}
        }));
    }

}
