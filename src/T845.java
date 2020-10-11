import java.util.LinkedList;
import java.util.Queue;

public class T845 {
    class Solution {
        public int longestMountain(int[] A) {
            int ans = 0;
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < A.length - 2; i++) {
                if (A[i] < A[i + 1] && A[i + 1] > A[i + 2]) {
                    queue.add(new int[]{i, i + 2});
                }
            }
            while (queue.size() > 0) {
                int[] mount = queue.poll();
                ans = Math.max(ans, mount[1] - mount[0] + 1);
                if (mount[0] > 0 && A[mount[0] - 1] < A[mount[0]]) {
                    queue.offer(new int[]{mount[0] - 1, mount[1]});
                }
                if (mount[1] < A.length - 1 && A[mount[0]] > A[mount[1] + 1]) {
                    queue.offer(new int[]{mount[0], mount[1] + 1});
                }
            }
            return ans;
        }
    }

}