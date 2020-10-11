import java.util.Comparator;
import java.util.PriorityQueue;

public class T1046 {
    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(32, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for(int stone : stones) {
                queue.offer(stone);
            }
            while(queue.size() > 1) {
                int stone1 = queue.poll();
                int stone2 = queue.poll();
                int minStone = Math.min(stone1, stone2);
                stone1 -= minStone;
                stone2 -= minStone;
                if(stone1 > 0) {
                    queue.offer(stone1);
                }
                if(stone2 > 0) {
                    queue.offer(stone2);
                }
            }
            if(queue.isEmpty()) {
                return 0;
            } else {
                return queue.peek();
            }
        }
    }
}
