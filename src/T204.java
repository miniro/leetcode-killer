import java.util.Arrays;

public class T204 {
    class Solution {
        public int countPrimes(int n) {
            boolean[] isPrime = new boolean[n];
            Arrays.fill(isPrime, true);
            for(int i = 2; i <= Math.sqrt(n); i++) {
                if(isPrime[i]) {
                    for(int j = i * i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            int cnt = 0;
            for(int i = 2; i < n; i++) {
                if(isPrime[i]) {
                    cnt ++;
                }
            }
            return cnt;
        }
    }
}
