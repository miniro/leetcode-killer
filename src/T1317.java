public class T1317 {
    class Solution {
        public int[] getNoZeroIntegers(int n) {
            for(int i = 1; i <= n / 2; i ++) {
                if(judge(i) && judge(n - i)) {
                    return new int[]{i, n - i};
                }
            }
            return null;
        }
        public boolean judge(int x) {
            while(x > 0) {
                if(x % 10 == 0) {
                    return false;
                }
                x /= 10;
            }
            return true;
        }
    }
}
