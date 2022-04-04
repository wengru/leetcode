public class LeetCode200 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i=0; i<grid.length; ++i) {
            for (int j=0; j<grid[i].length; ++j) {
                if (grid[i][j] == '1') {
                    sum++;
                    dfs(grid, i, j);
                }
            }
        }
        return sum;
    }

    void dfs(char[][] grid, int y, int x) {
        if (y >=0 && y < grid.length && x >=0 && x < grid[y].length && grid[y][x] == '1') {
            grid[y][x] = '0';
            dfs(grid, y+1, x);
            dfs(grid, y-1, x);
            dfs(grid, y, x+1);
            dfs(grid, y, x-1);
        }
    }

    public static void main(String[] args) {
        LeetCode200 l = new LeetCode200();
//        System.out.println(l.numIslands( // 1
//                new char[][] {
//                        new char[]{'1', '1', '1', '1', '0'},
//                        new char[]{'1', '1', '0', '1', '0'},
//                        new char[]{'1', '1', '0', '0', '0'},
//                        new char[]{'0', '0', '0', '0', '0'},
//                }
//        ));
//        System.out.println(l.numIslands( // 3
//                new char[][] {
//                        new char[]{'1', '1', '0', '0', '0'},
//                        new char[]{'1', '1', '0', '0', '0'},
//                        new char[]{'0', '0', '1', '0', '0'},
//                        new char[]{'0', '0', '0', '1', '1'},
//                }
//        ));
        System.out.println(l.numIslands( // 1
                new char[][] {
                        new char[]{'1', '1', '1'},
                        new char[]{'0', '1', '0'},
                        new char[]{'1', '1', '1'}
                }
        ));
    }

}
