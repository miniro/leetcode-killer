import java.util.Arrays;

public class T977 {
    class Solution {
        public int[] sortedSquares(int[] A) {
            int[] B = Arrays.stream(A).map(x -> x * x).toArray();
            Arrays.sort(B);
            return B;
        }
    }
}
