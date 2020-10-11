public class T45 {
    class Solution {
        public int jump(int[] nums) {
            int[] dp = new int[nums.length];
            for(int i = nums.length - 2; i >= 0; i --) {
                int minV = Integer.MAX_VALUE;
                for(int j = 1; j <= nums[i] && i + j < nums.length; j ++) {
                    minV = Math.min(minV, dp[i + j]);
                }
                dp[i] = minV == Integer.MAX_VALUE ? Integer.MAX_VALUE : minV + 1;
            }
            return dp[0];
        }
    }
}
