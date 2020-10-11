import java.util.ArrayList;
import java.util.List;

public class T906 {
    class Solution {
        public int superpalindromesInRange(String L, String R) {
            int cnt = 0;
            Long left = Long.parseLong(L);
            Long right = Long.parseLong(R);
            for (int i = 1; i < Math.min(100000, right); i++) {
                for (Long key : setPalindrome((long) i)) {
                    if (isPalindrome(key * key) && left <= key * key && key * key <= right) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        public List<Long> setPalindrome(Long value) {
            List<Long> ans = new ArrayList<>();
            Long t1 = value;
            Long t2 = value;
            Long result = 0L;
            int cnt = 0;
            while (t1 > 0) {
                t2 *= 10;
                result = result * 10 + t1 % 10;
                t1 /= 10;
                cnt++;
            }
            ans.add(result + t2);
            Long tmp = 1L;
            while (cnt > 1) {
                tmp *= 10;
                cnt--;
            }
            ans.add(result % tmp + t2 / 10);
            return ans;
        }

        public boolean isPalindrome(Long value) {
            String string = String.valueOf(value);
            for (int i = 0; i < string.length() / 2; i++) {
                if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }
}