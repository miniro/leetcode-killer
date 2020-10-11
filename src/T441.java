
public class T441 {
    class Solution {
        public int arrangeCoins(int n) {
            int sum = 0;
            int num = 0;
            while(sum <= n && sum >= 0) {
                sum += ++num;
            }
            return num - 1;
        }
    }
}
