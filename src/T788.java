import java.util.ArrayList;
import java.util.List;

public class T788 {
    class Solution {
        public int rotatedDigits(int N) {
            int[] arr = new int[10002];
            arr[1] = 0;
            for(int i = 2; i <= N; i ++) {
                arr[i] = test(i) ? arr[i - 1] + 1 : arr[i - 1];
            }
            return arr[N];
        }

        public boolean test(int n) {
            List<Integer> list = new ArrayList<>();
            while(n > 0) {
                list.add(n % 10);
                n /= 10;
            }
            int cnt = 0;
            for(int element : list) {
                if(element == 3 || element == 4 || element == 7) {
                    return false;
                } else if(element == 2 || element == 5 || element == 6 || element == 9) {
                    cnt ++;
                }
            }
            return cnt > 0;
        }
    }
}
