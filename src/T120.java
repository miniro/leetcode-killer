import java.util.Arrays;
import java.util.List;

public class T120 {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int[] dp = new int[triangle.size()];
            Arrays.fill(dp, Integer.MAX_VALUE);
            for(int i = 0; i < triangle.size(); i ++) {
                if(i == 0) {
                    dp[0] = triangle.get(0).get(0);
                    continue;
                }
                for(int j = i; j >= 0; j --) {
                    dp[j] = j > 0 ? Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j)
                            : dp[j] + triangle.get(i).get(j);
                }
            }
            int ans = Integer.MAX_VALUE;
            for(int i = 0; i < triangle.size(); i ++) {
                ans = Math.min(ans, dp[i]);
            }
            return ans;
        }
    }
}
