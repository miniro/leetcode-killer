import java.util.Arrays;

public class T908 {
    class Solution {
        public int smallestRangeI(int[] A, int K) {
            int maxV = Arrays.stream(A).max().getAsInt();
            int minV = Arrays.stream(A).min().getAsInt();
            return maxV - minV > K * 2 ? maxV - minV - K * 2 : 0;
        }
    }
}
