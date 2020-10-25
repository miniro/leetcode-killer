public class T860 {
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int cnt5 = 0, cnt10 = 0;
            for (int bill : bills) {
                switch (bill) {
                    case 5:
                        cnt5++;
                        break;
                    case 10: {
                        cnt5--;
                        cnt10++;
                    }
                    break;
                    case 20: {
                        if (cnt10 > 0) {
                            cnt10--;
                            cnt5--;
                        } else {
                            cnt5 -= 3;
                        }
                    }
                    break;
                }
                if (cnt5 < 0 || cnt10 < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}