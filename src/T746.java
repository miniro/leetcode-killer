import java.util.Arrays;
public class T746 {
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[cost.length];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = dp[1] = 0;
            for (int i = 2; i < cost.length; i++) {
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            }
            return Math.min(dp[cost.length - 2] + cost[cost.length - 2], dp[cost.length - 1] + cost[cost.length - 1]);
        }
    }
}