import java.util.PriorityQueue;

public class T215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int num : nums) {
                if(queue.isEmpty()) {
                    queue.offer(num);
                } else if(queue.size() < k) {
                    queue.offer(num);
                } else {
                    if(num > queue.peek()) {
                        queue.poll();
                        queue.offer(num);
                    }
                }
            }
            return queue.peek();
        }
    }
}
