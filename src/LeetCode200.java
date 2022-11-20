import java.util.ArrayList;
import java.util.List;

public class LeetCode200 {

//    public int numIslands(char[][] grid) {
//        if (grid == null || grid.length == 0) {
//            return 0;
//        }
//        int sum = 0;
//        for (int i=0; i<grid.length; ++i) {
//            for (int j=0; j<grid[i].length; ++j) {
//                if (grid[i][j] == '1') {
//                    sum++;
//                    dfs(grid, i, j);
//                }
//            }
//        }
//        return sum;
//    }
//
//    void dfs(char[][] grid, int y, int x) {
//        if (y >=0 && y < grid.length && x >=0 && x < grid[y].length && grid[y][x] == '1') {
//            grid[y][x] = '0';
//            dfs(grid, y+1, x);
//            dfs(grid, y-1, x);
//            dfs(grid, y, x+1);
//            dfs(grid, y, x-1);
//        }
//    }

    private int[] parents;

    private int[] rank;

    // 岛屿的数量
    private int count;

    public void init(char[][] grid) {
        count = 0;
        parents = new int[grid.length*grid[0].length];
        rank = new int[grid.length*grid[0].length];
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    int idx = i * grid[0].length + j;
                    parents[idx] = idx;
                    rank[idx] = 0;
                    count++;
                }
            }
        }
    }

    // 查找传入节点的根节点，查找途中路径压缩
    public int find(int x) {
        // 并查集核心代码
        return x == parents[x] ? x : (parents[x] = find(parents[x]));
    }

    // 传入两个结点，按秩合并，秩小的作为子数合并到秩大的树中去
    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] < rank[rooty]) {
                parents[rootx] = rooty;
            } else if (rank[rootx] > rooty) {
                parents[rooty] = rootx;
            } else {
                // 两棵树的秩相同
                parents[rootx] = rooty;
                rank[rooty]++;
            }
            count--; // 两个岛屿合并完之后，数量-1
        }
    }

    // union find
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rowLength = grid[0].length;
        init(grid);
        // 只要发现相邻的两块陆地就执行一次合并操作
        // 从左上角开始，按照右下的方向遍历，遍历过的地方置为'0'
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    // 合并右
                    if (j != grid[0].length - 1 && grid[i][j+1] == '1') {
                        union(i*rowLength + j, i*rowLength + j + 1);
                    }
                    // 合并下
                    if (i != grid.length - 1 && grid[i+1][j] == '1') {
                        union(i*rowLength + j, (i + 1)*rowLength + j);
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode200 l = new LeetCode200();
        System.out.println(l.numIslands( // 1
                new char[][] {
                        new char[]{'1', '1', '1', '1', '0'},
                        new char[]{'1', '1', '0', '1', '0'},
                        new char[]{'1', '1', '0', '0', '0'},
                        new char[]{'0', '0', '0', '0', '0'},
                }
        ));
        System.out.println(l.numIslands( // 3
                new char[][] {
                        new char[]{'1', '1', '0', '0', '0'},
                        new char[]{'1', '1', '0', '0', '0'},
                        new char[]{'0', '0', '1', '0', '0'},
                        new char[]{'0', '0', '0', '1', '1'},
                }
        ));
        System.out.println(l.numIslands( // 1
                new char[][] {
                        new char[]{'1', '1', '1'},
                        new char[]{'0', '1', '0'},
                        new char[]{'1', '1', '1'}
                }
        ));
    }

}
