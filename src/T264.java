import java.util.*;

public class T264 {
    class Solution {
        public int nthUglyNumber(int n) {
            PriorityQueue<Long> queue = new PriorityQueue<>();
            long ans = 0;
            int cnt = 0;
            queue.offer(1L);
            while(!queue.isEmpty()) {
                long value = queue.poll();
                ans = value;
                if(++cnt == n) {
                    break;
                }
                if(!queue.contains(value * 2)) {
                    queue.offer(value * 2);
                }
                if(!queue.contains(value * 3)) {
                    queue.offer(value * 3);
                }
                if(!queue.contains(value * 5)) {
                    queue.offer(value * 5);
                }
            }
            return (int)ans;
        }
    }
}
