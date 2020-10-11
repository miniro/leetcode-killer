import java.util.LinkedList;
import java.util.Queue;

public class T1162 {
    class Solution {
        public int maxDistance(int[][] grid) {
            Queue<int[]> queue = new LinkedList<>();
            Queue<int[]> tmpQueue = new LinkedList<>();
            int m = grid.length;
            int n = grid[0].length;
            int cnt = 0;
            int ans = 0;
            // boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        queue.offer(new int[]{i, j});
                        cnt++;
                    }
                }
            }
            if (cnt == 0 || cnt == m * n) {
                return -1;
            }
            while (!queue.isEmpty() || !tmpQueue.isEmpty()) {
                while (!queue.isEmpty()) {
                    tmpQueue.offer(queue.poll());
                }
                while (!tmpQueue.isEmpty()) {
                    int[] value = tmpQueue.poll();
                    int[][] directions = new int[][]{
                            {value[0] - 1, value[1]},
                            {value[0] + 1, value[1]},
                            {value[0], value[1] + 1},
                            {value[0], value[1] - 1}
                    };
                    for (int[] direction : directions) {
                        if (isValid(direction, m, n) && grid[direction[0]][direction[1]] == 0) {
                            queue.offer(direction);
                            grid[direction[0]][direction[1]] = 1;
                        }
                    }
                }
                ans++;
            }
            return ans - 1;
        }

        public boolean isValid(int[] direction, int m, int n) {
            if (direction[0] < 0 || direction[0] >= m || direction[1] < 0 || direction[1] >= n) {
                return false;
            }
            return true;
        }
    }
}