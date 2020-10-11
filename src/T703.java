import java.util.PriorityQueue;

public class T703 {
    class KthLargest {

        private PriorityQueue<Integer> queue;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.queue = new PriorityQueue<>();
            for(int i : nums) {
                this.add(i);
            }
        }

        public int add(int val) {
            if(this.queue.size() < this.k) {
                this.queue.offer(val);
            } else if(val > this.queue.peek()) {
                this.queue.poll();
                this.queue.offer(val);
                return this.queue.peek();
            }
            return this.queue.peek();
        }
    }
}
