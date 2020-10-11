public class T494 {
    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            if (S > 1000 || S < -1000) {
                return 0;
            }
            int[][] dp = new int[21][2001];
            for (int i = 1; i <= nums.length; i++) {
                if (i == 1) {
                    if (nums[0] == 0) {
                        dp[i][1000] = 2;
                    } else {
                        dp[i][1000 + nums[0]] = dp[i][1000 - nums[0]] = 1;
                    }
                    continue;
                }
                for (int j = -1000; j <= 1000; j++) {
                    if (j - nums[i - 1] >= -1000) {
                        dp[i][j + 1000] += dp[i - 1][1000 + j - nums[i - 1]];
                    }
                    if (j + nums[i - 1] <= 1000) {
                        dp[i][j + 1000] += dp[i - 1][1000 + j + nums[i - 1]];
                    }
                }
            }
            return dp[nums.length][S + 1000];
        }
    }
}