public class T221 {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if(matrix.length == 0) {
                return 0;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int ans = 0;
            int[][] dp = new int[m][n];
            for(int i = 0; i < m; i ++) {
                for(int j = 0; j < n; j ++) {
                    if(matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else {
                        if(i > 0 && j > 0) {
                            dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                        } else {
                            dp[i][j] = 1;
                        }
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            return ans * ans;
        }
    }
}
