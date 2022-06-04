public class LeetCode79 {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j=0; j < board[0].length; ++j) {
                if (existHelper(board, word, j, i, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existHelper(char[][] board, String word, int x, int y, int idx) {
        if (idx == word.length() - 1) {
            return board[y][x] == word.charAt(idx) ? true : false;
        }
        // 如果第一个字母就已经不一样了，那就直接跳过
        if (board[y][x] != word.charAt(idx)) {
            return false;
        }
        // 回溯过的地方打标记
        char c = board[y][x];
        board[y][x] = '.';
        if (y > 0 && '.' != board[y-1][x]) {
            if (existHelper(board, word, x, y - 1, idx + 1)) {
                return true;
            }
        }
        if (y != board.length - 1 && '.' != board[y+1][x]) {
            if (existHelper(board, word, x, y + 1, idx + 1)) {
                return true;
            }
        }
        if (x > 0 && '.' != board[y][x-1]) {
            if (existHelper(board, word, x - 1, y, idx + 1)) {
                return true;
            }
        }
        if (x != board[0].length - 1 && '.' != board[y][x+1]) {
            if (existHelper(board, word, x + 1, y, idx + 1)) {
                return true;
            }
        }
        // 四个方向回溯完之后还原
        board[y][x] = c;
        // 四个方向深度遍历都不符合，则返回false
        return false;
    }

    public static void main(String[] args) {
        LeetCode79 l = new LeetCode79();
        System.out.println(l.exist(
                new char[][]{
                    new char[]{'A','B','C','E'},
                    new char[]{'S','F','C','S'},
                    new char[]{'A','D','E','E'}
                },
                "ABCCED"
        )); // true
        System.out.println(l.exist(
                new char[][]{
                        new char[]{'A','B','C','E'},
                        new char[]{'S','F','C','S'},
                        new char[]{'A','D','E','E'}
                },
                "SEE"
        )); // true
        System.out.println(l.exist(
                new char[][]{
                        new char[]{'A','B','C','E'},
                        new char[]{'S','F','C','S'},
                        new char[]{'A','D','E','E'}
                },
                "ABCB"
        )); // false
        System.out.println(l.exist(
                new char[][]{
                        new char[]{'a','a'}
                },
                "aaa"
        )); // false
        System.out.println(l.exist(
                new char[][]{
                        new char[]{'C','A','A'},
                        new char[]{'A','A','A'},
                        new char[]{'B','C','D'}
                },
                "AAB"
        )); // true
    }

}
