public class T121 {
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices.length == 0) {
                return 0;
            }
            int minV = prices[0];
            int ans = 0;
            for(int i = 1; i < prices.length; i ++) {
                ans = Math.max(ans, Math.max(0, prices[i] - minV));
                minV = Math.min(minV, prices[i]);
            }
            return ans;
        }
    }
}
