import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T207 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int cnt = 0;
            List<List<Integer>> graph = new ArrayList<>();
            int[] preNUm = new int[numCourses];
            for(int i = 0; i < numCourses; i ++) {
                List<Integer> list = new ArrayList<>();
                graph.add(list);
            }
            for(int[] require : prerequisites) {
                graph.get(require[1]).add(require[0]);
                preNUm[require[0]] ++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < numCourses; i ++) {
                if(preNUm[i] == 0) {
                    queue.add(i);
                    cnt ++;
                }
            }
            while(!queue.isEmpty()) {
                int key = queue.poll();
                for(int value : graph.get(key)) {
                    preNUm[value] --;
                    if(preNUm[value] == 0) {
                        queue.add(value);
                        cnt ++;
                    }
                }
            }
            return cnt == numCourses;
        }
    }
}
