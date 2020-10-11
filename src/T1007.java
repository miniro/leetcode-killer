import java.util.Arrays;

public class T1007 {
    class Solution {
        public int minDominoRotations(int[] A, int[] B) {
            int n = A.length;
            int[] a = new int[7];
            int[] b = new int[7];
            int[] c = new int[7];
            for(int i = 0; i < n; i ++) {
                a[A[i]] ++;
                b[B[i]] ++;
                c[A[i]] ++;
                if(A[i] != B[i]) {
                    c[B[i]] ++;
                }
            }
            int ans = Integer.MAX_VALUE;
            for(int i = 1; i <= 6; i ++) {
                if(c[i] == n && a[i] + b[i] >= n) {
                    ans = Math.min(ans, n - Math.max(a[i], b[i]));
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
}
