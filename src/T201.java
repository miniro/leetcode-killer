public class T201 {
    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            int[] a = new int[32];
            int[] b = new int[32];
            int k1 = 0;
            int k2 = 0;
            int ans = 0;
            boolean tag = false;
            while(m > 0) {
                a[k1 ++] = m % 2;
                m /= 2;
            }
            while(n > 0) {
                b[k2 ++] = n % 2;
                n /= 2;
            }
            for(int i = Math.max(k1, k2) - 1; i >= 0; i --) {
                if(tag) {
                    ans *= 2;
                } else {
                    if(a[i] != b[i]) {
                        ans *= 2;
                        tag = true;
                    } else {
                        ans = ans * 2 + a[i];
                    }
                }
            }
            return ans;
        }
    }
}
