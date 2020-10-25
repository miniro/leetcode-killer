public class T300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if(nums.length == 0) {
                return 0;
            }
            int ans = 1;
            int[] dp = new int[nums.length];
            dp[0] = 1;
            for(int i = 1; i < nums.length; i ++) {
                for(int j = 0; j < i; j ++) {
                    if(nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                }
                dp[i] ++;
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }
}
