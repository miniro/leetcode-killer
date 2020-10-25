public class T1578 {
    class Solution {
        public int minCost(String s, int[] cost) {
            int pre = 0;
            int ans = 0;
            for(int i = 1; i < cost.length; i ++) {
                if(s.charAt(pre) == s.charAt(i)) {
                    if(cost[pre] < cost[i]) {
                        ans += cost[pre];
                        pre = i;
                    } else {
                        ans += cost[i];
                    }
                } else {
                    pre = i;
                }
            }
            return ans;
        }
    }
}
