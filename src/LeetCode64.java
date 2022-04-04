public class LeetCode64 {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        for (int i=0; i<grid.length; ++i) {
            for (int j=0; j<grid[i].length; ++j) {
                if (i > 0 && j > 0) {
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                } else if (i > 0) {
                    grid[i][j] += grid[i-1][j];
                } else if (j > 0){
                    grid[i][j] += grid[i][j-1];
                } else {
                    continue;
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        LeetCode64 l = new LeetCode64();
        System.out.println(l.minPathSum(new int[][]{
                new int[]{1,3,1},
                new int[]{1,5,1},
                new int[]{4,2,1}
        })); // 7
        System.out.println(l.minPathSum(new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6}
        })); // 12
    }
}
