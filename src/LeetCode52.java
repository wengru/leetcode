public class LeetCode52 {

    public int totalNQueens(int n) {
        n = n > 0 ? n : 0;
        int[] vertical = new int[n], res = new int[1];
        int[][] bias = new int[2][ n > 0 ? n*2-1 : 0];
        backTracking(res, 0, vertical, bias, new int[n][n]);
        return res[0];
    }

    void backTracking(int[] res, int x, int[] vertical, int[][] bias, int[][] grid) {
        for (int i=0; i<grid.length; ++i) {
            int l = i-x+grid.length-1;
            int r = (grid.length-1)*2-i-x; // grid.length-1-j-i+grid.length-1
            if (vertical[i] == 1 || bias[0][l] == 1 || bias[1][r] == 1) {
                continue;
            }
            grid[x][i] = 1;
            vertical[i] = 1;
            bias[0][l] = 1;
            bias[1][r] = 1;
            if (x == grid.length-1) {
                res[0]++;
            } else {
                backTracking(res, x+1, vertical, bias, grid);
            }
            grid[x][i] = 0;
            vertical[i] = 0;
            bias[0][l] = 0;
            bias[1][r] = 0;
        }
    }

    public static void main(String[] args) {
        LeetCode52 l = new LeetCode52();
        System.out.println(l.totalNQueens(4)); // 2
        System.out.println(l.totalNQueens(1)); // 1
    }

}
