import java.util.Arrays;
import java.util.PriorityQueue;

public class T1005 {
    class Solution {
        public int largestSumAfterKNegations(int[] A, int K) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            Arrays.stream(A).filter(x -> x < 0).forEach(queue::add);
            int sum = Arrays.stream(A).sum();
            while (!queue.isEmpty() && K > 0) {
                sum += Math.abs(queue.poll()) * 2;
                K--;
            }
            if (K > 0) {
                int value = Integer.MAX_VALUE;
                for (int x : A) {
                    value = Math.abs(x) < Math.abs(value) ? Math.abs(x) : value;
                }
                if (K % 2 == 1) {
                    sum -= value * 2;
                }
            }
            return sum;
        }
    }

}