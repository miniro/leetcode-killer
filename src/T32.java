import java.util.Arrays;
public class T32 {
    class Solution {
        public int longestValidParentheses(String s) {
            int ans = 0;
            int[] dp = new int[s.length()];
            if (s.startsWith("()")) {
                dp[1] = 2;
                ans = 2;
            }
            for (int i = 2; i < s.length(); i++) {
                if (dp[i - 1] > 0) {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(' && s.charAt(i) == ')') {
                        dp[i] = dp[i - 1] + 2;
                        if (i - dp[i] >= 0) {
                            dp[i] += dp[i - dp[i]];
                        }
                    } else {
                        dp[i] = 0;
                    }
                } else {
                    if (s.charAt(i - 1) == '(' && s.charAt(i) == ')') {
                        dp[i] = 2;
                        dp[i] += dp[i - 2];
                    }
                }
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }
}
