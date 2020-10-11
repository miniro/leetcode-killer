import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T841 {
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int n = rooms.size();
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            visited[0] = true;
            while (!queue.isEmpty()) {
                int index = queue.poll();
                for(Integer key : rooms.get(index)) {
                    if(!visited[key]) {
                        queue.offer(key);
                        visited[key] = true;
                    }
                }
            }
            for(boolean result : visited) {
                if(!result) {
                    return false;
                }
            }
            return true;
        }
    }
}
