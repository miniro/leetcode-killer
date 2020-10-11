import java.util.LinkedList;
import java.util.Queue;

public class O59 {
    class MaxQueue {
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> max = new LinkedList<>();

        public MaxQueue() {

        }

        public int max_value() {
            return max.isEmpty() ? -1 : max.getFirst();
        }

        public void push_back(int value) {
            queue.offer(value);
            while(!max.isEmpty() && max.getLast() < value) {
                max.remove(max.getLast());
            }
            max.add(value);
        }

        public int pop_front() {
            if(queue.isEmpty()) {
                return -1;
            }
            int num = queue.poll();
            if(num == max.getFirst()) {
                max.remove(max.getFirst());
            }
            return num;
        }
    }
}
