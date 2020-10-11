public class T172 {
    class Solution {
        public int trailingZeroes(int n) {
            if (n == 0) {
                return 0;
            }
            int a = 1;
            int cnt = 0;
            while (a <= n) {
                a *= 5;
                cnt++;
            }
            cnt--;
            return cnt * (cnt - 1) / 2 + n / 5;
        }
    }
}
