public class T1034 {
    class Solution {
        boolean[][] visited;
        int[][] grid;
        int[][] steps = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        int m, n;
        public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
            this.grid = grid;
            visited = new boolean[m][n];
            m = grid.length;
            n = grid[0].length;
            dfs(r0, c0, color);
            return this.grid;
        }

        public void dfs(int x, int y, int color) {
            visited[x][y] = true;
            boolean tag = true;
            for(int[] step : steps) {
                if(isValid(step[0] + x, step[1] + y) &&
                        grid[step[0] + x][step[1] + y] == grid[x][y]) {
                    dfs(x + step[0], y + step[1], color);
                    tag = false;
                }
            }
            if(tag) {
                grid[x][y] = color;
            }
            visited[x][y] = false;
        }

        public boolean isValid(int x, int y) {
            if(x < 0 || x >= m || y < 0 || y >= n) {
                return false;
            }
            return true;
        }
    }
}
