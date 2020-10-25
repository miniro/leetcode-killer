public class T304 {
    class NumMatrix {
        int m, n;
        int[][] dp;
        public NumMatrix(int[][] matrix) {
            m = matrix.length;
            if(m > 0) {
                n = matrix[0].length;
            }
            dp = new int[m][n];
            for(int i = 0; i < m; i ++) {
                for(int j = 0; j < n; j ++) {
                    if(i > 0 && j > 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
                    } else if(i > 0) {
                        dp[i][j] = dp[i - 1][j] + matrix[i][j];
                    } else if(j > 0) {
                        dp[i][j] = dp[i][j - 1] + matrix[i][j];
                    } else {
                        dp[i][j] = matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if(row1 > 0 && col1 > 0) {
                return dp[row2][col2] - dp[row1 - 1][col2] - dp[row2][col1 - 1] + dp[row1 - 1][col1 - 1];
            } else if(row1 > 0) {
                return dp[row2][col2] - dp[row1 - 1][col2];
            } else if(col1 > 0) {
                return dp[row2][col2] - dp[row2][col1 - 1];
            } else {
                return dp[row2][col2];
            }
        }
    }
}
