import java.util.Comparator;
import java.util.PriorityQueue;

public class O40 {
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int val : arr) {
                queue.offer(val);
            }
            int[] result = new int[k];
            for(int i=0;i<k;i++) {
                result[i] = queue.poll();
            }
            return result;
        }
    }
}
