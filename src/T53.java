public class T53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int ans = 0;
            int now = 0;
            int maxV = Integer.MIN_VALUE;
            boolean tag = false;
            for(int value : nums) {
                if(value > 0) {
                    tag = true;
                }
                maxV = Math.max(maxV, value);
                now += value;
                if(now < 0) {
                    now = 0;
                }
                ans = Math.max(ans, now);
            }
            ans = !tag ? maxV : ans;
            return ans;
        }
    }
}
