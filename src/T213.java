import java.util.Arrays;

public class T213 {
    class Solution {
        public int rob(int[] nums) {
            if(nums.length == 1) {
                return nums[0];
            }
            int ans = 0;
            int[] dp = new int[nums.length];
            for(int i = 1; i < nums.length; i ++) {
                if(i == 1) {
                    dp[i] = nums[i - 1];
                } else {
                    dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
                }
                ans = Math.max(ans, dp[i]);
            }
            Arrays.fill(dp, 0);
            for(int i = 1; i < nums.length; i ++) {
                if(i == 1) {
                    dp[i] = nums[i];
                } else {
                    dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
                }
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }
}
