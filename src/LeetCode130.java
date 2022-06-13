public class LeetCode130 {

    public void solve(char[][] board) {
        return;
    }

    public static void main(String[] args) {
        LeetCode130 l = new LeetCode130();
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
