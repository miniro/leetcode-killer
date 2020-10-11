public class T1550 {
    class Solution {
        public boolean threeConsecutiveOdds(int[] arr) {
            int ans = 0;
            int maxA = 0;
            for(int value : arr) {
                if(value % 2 == 1) {
                    ans ++;
                    maxA = Math.max(maxA, ans);
                } else {
                    ans = 0;
                }
            }
            return maxA >= 3;
        }
    }
}
