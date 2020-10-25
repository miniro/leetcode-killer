import java.util.*;

public class T406 {
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            int[][] ans = new int[people.length][2];
            int k = 0;
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
                if(o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            });
            Map<Integer, List<int[]>> map = new HashMap<>();
            for(int[] person : people) {
                if(!map.containsKey(person[1])) {
                    List<int[]> list = new ArrayList<>();
                    map.put(person[1], list);
                }
                map.get(person[1]).add(person);
            }
            queue.addAll(map.get(0));
            while(queue.size() != 0) {
                ans[k ++] = queue.poll();
                queue.addAll(map.getOrDefault(k, new ArrayList<>()));
            }
            return ans;
        }
    }
}
