public class T91 {
    class Solution {
        public int numDecodings(String s) {
            if (s.length() == 0) {
                return 0;
            }
            if (s.length() == 1) {
                if (s.charAt(0) > '0' && s.charAt(0) <= '9') {
                    return 1;
                }
                return 0;
            }
            int[] dp = new int[s.length() + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) > '0' && s.charAt(0) <= '9' ? 1 : 0;
            for (int i = 2; i <= s.length(); i++) {
                int value = Integer.parseInt(s.substring(i - 2, i));
                if (value >= 10 && value <= 26) {
                    dp[i] += dp[i - 2];
                }
                if (s.charAt(i - 1) > '0' && s.charAt(i - 1) <= '9') {
                    dp[i] += dp[i - 1];
                }
            }
            return dp[s.length()];
        }
    }
}
