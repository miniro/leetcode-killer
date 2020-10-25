public class T931 {
    class Solution {
        public int minFallingPathSum(int[][] A) {
            if(A.length == 0) {
                return 0;
            }
            int n = A.length;
            int ans = Integer.MAX_VALUE;
            int[][] dp = new int[n][n];
            for(int i = 0; i < n; i ++) {
                for(int j = 0; j < n; j ++) {
                    if(i == 0) {
                        dp[i][j] = A[i][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                        if(j > 0) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                        }
                        if(j < n - 1) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1]);
                        }
                        dp[i][j] += A[i][j];
                    }
                    if(i == n - 1) {
                        ans = Math.min(ans, dp[i][j]);
                    }
                }
            }
            return ans;
        }
    }
}
