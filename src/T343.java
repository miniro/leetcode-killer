public class T343 {
    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = i;
            }
            for (int i = 2; i <= n; i++) {
                int value = 0;
                for (int j = 1; j < i; j++) {
                    value = Math.max(value, Math.max(dp[j], j) * (i - j));
                }
                dp[i] = value;
            }
            return dp[n];
        }
    }
}
