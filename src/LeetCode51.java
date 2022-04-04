import java.util.*;

public class LeetCode51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        n = n > 0 ? n : 0;
        int[] vertical = new int[n];
        int[][] bias = new int[2][ n > 0 ? n*2-1 : 0];
        backTracking(res, 0, vertical, bias, new int[n][n]);
        return res;
    }

    void backTracking(List<List<String>> res, int x, int[] vertical, int[][] bias, int[][] grid) {
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
                List<String> list = new ArrayList<>();
                for (int[] nums : grid) {
                    StringBuilder sb = new StringBuilder();
                    for (int num : nums) {
                        sb.append(num == 0 ? "." : "Q");
                    }
                    list.add(sb.toString());
                }
                res.add(list);
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
        LeetCode51 l = new LeetCode51();
        // [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
        System.out.println(l.solveNQueens(4));
        // [["Q"]]
        System.out.println(l.solveNQueens(1));
        System.out.println(l.solveNQueens(-1));
    }

}
