public class T1025 {
    class Solution {
        public boolean divisorGame(int N) {
            boolean[] dp = new boolean[N + 1];
            for(int i = 2; i <= N; i ++) {
                dp[i] = true;
                for(int j = 1; j <= Math.sqrt(i); j ++) {
                    if(i % j == 0) {
                        dp[i] = dp[i] && dp[i - j];
                    }
                }
                dp[i] = !dp[i];
            }
            return dp[N];
        }
    }
}
