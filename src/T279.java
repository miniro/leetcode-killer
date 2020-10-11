public class T279 {
    class Solution {
        public int numSquares(int n) {
            int m = (int)Math.sqrt(n);
            int[] arr = new int[m];
            int[] dp = new int[n + 1];
            for(int i = 0; i < m; i ++) {
                arr[i] = (i + 1) * (i + 1);
            }
            for(int i = 1; i <= n; i ++) {
                int minV = Integer.MAX_VALUE;
                for(int j = 0; j < m; j ++) {
                    if(i - arr[j] <= 0) {
                        if(i - arr[j] == 0) {
                            dp[i] = 1;
                        }
                        break;
                    }
                    minV = Math.min(minV, dp[i - arr[j]]);
                    dp[i] = minV + 1;
                }
            }
            return dp[n];
        }
    }
}
