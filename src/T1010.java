import java.util.Arrays;
public class T1010 {
    class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            int result = 0;
            int[] arr = new int[502];
            Arrays.fill(arr, 0);
            for (int key : time) {
                arr[key]++;
            }
            for (int i = 1; i <= 500; i++) {
                if (arr[i] == 0) {
                    continue;
                }
                int cnt = 0;
                for (int j = (i / 60 + 1) * 60 - i; j <= 500; j += 60) {
                    if (arr[j] == 0) {
                        continue;
                    }
                    if (j > i) {
                        cnt += arr[j] * arr[i];
                    } else if (j == i) {
                        cnt += getValue(arr[i]);
                    }
                }
                result += cnt;
            }
            return result;
        }

        public int getValue(int n) {
            int result = 0;
            for (int i = 1; i < n; i++) {
                result += i;
            }
            return result;
        }
    }
}