import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T139 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length()];
            for(int i = 0; i < s.length(); i ++) {
                for(int j = i; j >= 0; j --) {
                    if(set.contains(s.substring(j, i + 1))) {
                        dp[i] = j <= 0 || (dp[i] || dp[j - 1]);
                    }
                }
            }
            return dp[s.length() - 1];
        }
    }
}
