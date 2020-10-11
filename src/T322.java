import java.util.Arrays;


    class Solution {
        public int coinChange(int[] coins, int amount) {
            if(amount == 0) {
                return 0;
            }
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for(int i = 0; i < coins.length; i ++) {
                for(int j = coins[i]; j <= amount; j ++) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
            return dp[amount] <= amount ? dp[amount] : -1;
        }
    }

