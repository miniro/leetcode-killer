import java.util.Arrays;

public class T980 {
    class Solution {
        boolean[][] visited;
        int[][] grid;
        int[] begin;
        int[] end;
        int cnt;
        int m, n;
        int result;

        public int uniquePathsIII(int[][] grid) {
            this.grid = grid;
            m = grid.length;
            n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    switch (grid[i][j]) {
                        case 1:
                            begin = new int[]{i, j};
                            break;
                        case 2:
                            end = new int[]{i, j};
                            break;
                        case 0:
                            cnt++;
                            break;
                    }
                }
            }
            visited = new boolean[m][n];
            dfs(begin[0], begin[1], 0);
            return result;
        }

        public void dfs(int x, int y, int depth) {
            if (!isValid(x, y) || grid[x][y] == -1 || visited[x][y]) {
                return;
            }
            visited[x][y] = true;
            if (x == end[0] && y == end[1]) {
                if (depth == cnt + 1) {
                    result++;
                }
                visited[x][y] = false;
                return;
            }
            dfs(x - 1, y, depth + 1);
            dfs(x + 1, y, depth + 1);
            dfs(x, y + 1, depth + 1);
            dfs(x, y - 1, depth + 1);
            visited[x][y] = false;
        }

        public boolean isValid(int x, int y) {
            if (x < 0 || x >= m || y < 0 || y >= n) {
                return false;
            }
            return true;
        }
    }
}