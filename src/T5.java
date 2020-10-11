public class T5 {
    class Solution {
        public String longestPalindrome(String s) {
            String ans = null;
            boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
            for (int step = 1; step <= s.length(); step++) {
                for (int i = 0; i + step <= s.length(); i++) {
                    if (step == 1) {
                        dp[i][i + step] = true;
                    } else {
                        if (s.charAt(i) == s.charAt(i + step - 1)) {
                            if (step == 2) {
                                dp[i][i + step] = true;
                            } else {
                                dp[i][i + step] = dp[i + 1][i + step - 1];
                            }
                        }
                    }
                    if (dp[i][i + step]) {
                        ans = s.substring(i, i + step);
                    }
                }
            }
            return ans;
        }
    }
}
