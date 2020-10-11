public class T122 {
    class Solution {
        public int maxProfit(int[] prices) {
            int prev = prices[0];
            int ans = 0;
            for(int i = 1; i < prices.length; i ++) {
                if(prev < prices[i]) {
                    ans += prices[i] - prev;
                }
                prev = prices[i];
            }
            return ans;
        }
    }
}
