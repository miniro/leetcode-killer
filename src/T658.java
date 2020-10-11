import java.util.*;

public class T658 {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
                if(Math.abs(o1 - x) != Math.abs(o2 - x)) {
                    return Math.abs(o2 - x) - Math.abs(o1 - x);
                }
                return o2 - o1;
            });
            for(int value : arr) {
                queue.offer(value);
                if(queue.size() > k) {
                    queue.poll();
                }
            }
            List<Integer> ans = new ArrayList<>(queue);
            Collections.sort(ans);
            return ans;
        }
    }
}