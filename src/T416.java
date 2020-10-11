import java.util.Arrays;

public class T416{
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 == 1) {
                return false;
            }
            int V = sum / 2;
            int[] dp = new int[V + 1];
            Arrays.fill(dp, Integer.MIN_VALUE);
            dp[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = V; j >= nums[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + 1);
                }
            }
            return dp[V] > 0;
        }
    }
}
