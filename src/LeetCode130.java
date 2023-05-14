import java.util.HashSet;
import java.util.Set;

public class LeetCode130 {

    // 父节点
    private int[] parent;

    // 秩
    private int[] rank;

    public int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    // union find
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        // 初始化
        parent = new int[board.length*board[0].length];
        rank = new int[board.length*board[0].length]; // default 0
        Set<Integer> rootSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                parent[i*board[0].length + j] = i*board[0].length + j;
            }
        }
        // 并查集处理出需要翻转的头节点
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    // 对每个遍历到的位置先置为O，后面如果没有完全被包围再还原回去
                    board[i][j] = 'X';
                    int curIdx = i*board[0].length + j;
                    if (i != board.length - 1 && board[i + 1][j] == 'O') {
                        union(curIdx, (i + 1)*board[0].length + j);
                    }
                    if (j != board[0].length - 1 && board[i][j + 1] == 'O') {
                        union(curIdx, i*board[0].length + j + 1);
                    }
                    if (i == board.length - 1 || j == board[0].length - 1 || i == 0 || j == 0) {
                        rootSet.add(find(curIdx));
                    }
                }
            }
        }
        // 还原
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (rootSet.contains(find(i*board[0].length + j))) {
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        LeetCode130 l = new LeetCode130();
        l.solve(new char[][]{
                new char[]{'X','X','X','X','O','X'},
                new char[]{'O','X','X','O','O','X'},
                new char[]{'X','O','X','O','O','O'},
                new char[]{'X','O','O','O','X','O'},
                new char[]{'O','O','X','X','O','X'},
                new char[]{'X','O','X','O','X','X'}
        });
        l.solve(new char[][]{
                new char[]{'X','O','X','O','X','O'},
                new char[]{'O','X','O','X','O','X'},
                new char[]{'X','O','X','O','X','O'},
                new char[]{'O','X','O','X','O','X'}
        }); // [["X","O","X","O","X","O"],["O","X","X","X","X","X"],["X","X","X","X","X","O"],["O","X","O","X","O","X"]]
        l.solve(
                new char[][]{
                        new char[]{'X','X','X','X'},
                        new char[]{'X','O','O','X'},
                        new char[]{'X','X','O','X'},
                        new char[]{'X','O','X','X'}
            }
        ); // [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
        l.solve(
                new char[][]{
                        new char[]{'X'}
                }
        ); // [["X"]]
    }

}
