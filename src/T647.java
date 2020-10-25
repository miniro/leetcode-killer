public class T647 {
    class Solution {
        public int countSubstrings(String s) {
            if(s.length() == 0) {
                return 0;
            }
            int ans = 0;
            boolean[][] dp = new boolean[s.length()][s.length()];
            for(int step = 1; step <= s.length(); step ++) {
                for(int i = 0; i + step <= s.length(); i ++) {
                    if(step == 1) {
                        dp[i][i] = true;
                    } else if(step == 2) {
                        if(s.charAt(i) == s.charAt(i + 1)) {
                            dp[i][i + 1] = true;
                        }
                    } else {
                        if(s.charAt(i) == s.charAt(i + step - 1)) {
                            dp[i][i + step - 1] = dp[i + 1][i + step - 2];
                        }
                    }
                    if(dp[i][i + step - 1]) {
                        ans ++;
                    }
                }
            }
            return ans;
        }
    }
}
