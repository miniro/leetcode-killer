public class T367 {
    class Solution {
        public boolean isPerfectSquare(int num) {
            int left = 1;
            int right = num > 10 ? num / 2 : num;
            while(left <= right) {
                int mid = (left + right) / 2;
                if(mid == num / mid && num % mid == 0) {
                    return true;
                } else if(mid < num / mid || mid == num / mid && num % mid != 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }
}
