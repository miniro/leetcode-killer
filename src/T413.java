public class T413 {
    class Solution {
        public int numberOfArithmeticSlices(int[] A) {
            int cnt = 0;
            int n = A.length;
            boolean[][] dp = new boolean[n][n];
            for(int i = 0; i + 2 < n; i ++) {
                if(A[i + 2] - A[i + 1] == A[i + 1] - A[i]) {
                    dp[i][i + 2] = true;
                    cnt ++;
                }
            }
            for(int step = 3; step < n; step ++) {
                for(int i = 0; i + step < n; i ++) {
                    dp[i][i + step] = dp[i][i + step - 1] && dp[i + 1][i + step];
                    if(dp[i][i + step]) {
                        cnt ++;
                    }
                }
            }
            return cnt;
        }
    }
}
