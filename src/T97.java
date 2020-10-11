public class T97 {
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
            for (int i = 1; i <= s3.length(); i++) {
                for (int j = 1; j <= s1.length(); j++) {
                    if (s1.charAt(j - 1) == s2.charAt(i - j)) {
                        if (s1.charAt(j - 1) == s3.charAt(i - 1)) {
                            dp[j][i + 1 - j] = dp[j - 1][i + 1 - j] || dp[j][i - j];
                            break;
                        }
                    } else {
                        if (s1.charAt(j - 1) == s3.charAt(i - 1)) {
                            dp[j][i + 1 - j] = dp[j - 1][i + 1 - j];
                            break;
                        } else if (s2.charAt(i - j) == s3.charAt(i - 1)) {
                            dp[j][i + 1 - j] = dp[j][i - j];
                            break;
                        }
                    }
                }
            }
            return dp[s1.length()][s2.length()];
        }
    }

}