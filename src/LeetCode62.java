public class LeetCode62 {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i=0; i<m; ++i) {
            for (int j=0; j<n; ++j) {
                if (i !=0 && j != 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = i == 0 ? dp[i][j-1] : dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        LeetCode62 l = new LeetCode62();
        System.out.println(l.uniquePaths(3, 7)); // 28
        System.out.println(l.uniquePaths(3, 2)); // 3
        System.out.println(l.uniquePaths(7, 3)); // 28
        System.out.println(l.uniquePaths(3, 3)); // 6
    }

}
