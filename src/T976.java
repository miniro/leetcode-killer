import java.util.Arrays;

public class T976 {
    class Solution {
        public int largestPerimeter(int[] A) {
            Arrays.sort(A);
            for(int i=0;i<A.length/2;i++) {
                int tmp = A[i];
                A[i] = A[A.length - 1 - i];
                A[A.length - 1 - i] = tmp;
            }
            for(int i=0;i<A.length-2;i++) {
                if(A[i+1] + A[i+2] > A[i]) {
                    return A[i] + A[i+1] + A[i+2];
                }
            }
            return 0;
        }
    }
}
