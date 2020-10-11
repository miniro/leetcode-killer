public class T1220 {
    class Solution {
        public int countVowelPermutation(int n) {
            if(n == 1) {
                return 5;
            }
            int[][] dp = new int[5][n + 1];
            dp[0][2] = dp[4][2] = 1;
            dp[1][2] = dp[3][2] = 2;
            dp[2][2] = 4;
            for(int i = 3; i <= n; i ++) {
                dp[0][i] = dp[1][i - 1];
                dp[1][i] = dp[0][i - 1] + dp[2][i - 1];
                dp[2][i] = (dp[0][i - 1] + dp[1][i - 1]) % 1000000007 + (dp[3][i - 1] + dp[4][i - 1]) % 1000000007;
                dp[3][i] = dp[2][i - 1] + dp[4][i - 1];
                dp[4][i] = dp[0][i - 1];
                for(int j = 0; j < 5; j ++) {
                    dp[j][i] %= 1000000007;
                }
            }
            int result = 0;
            for(int j = 0; j < 5; j ++) {
                result += dp[j][n];
                result %= 1000000007;
            }
            return result;
        }

//        public int getIndex(char c) {
//            int num = -1;
//            switch (c) {
//                case 'a': num = 0;break;
//                case 'e': num = 1;break;
//                case 'i': num = 2;break;
//                case 'o': num = 3;break;
//                case 'u': num = 4;break;
//            }
//            return num;
//        }
    }
}
