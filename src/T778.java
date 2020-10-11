public class T778 {
    class Solution {
        int m;
        int n;
        public int swimInWater(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            int t = 0;
            while(true) {
                boolean[][] visited = new boolean[m][n];
                dfs(0, 0, grid, t, visited);
                if(visited[m - 1][n - 1]) {
                    return t;
                }
                t ++;
            }
        }

        public void dfs(int x, int y, int[][] grid, int t, boolean[][] visited) {
            if(isValid(x, y) && !visited[x][y] && grid[x][y] - t <= 0) {
                visited[x][y] = true;
                dfs(x - 1, y, grid, t, visited);
                dfs(x + 1, y, grid, t, visited);
                dfs(x, y - 1, grid, t, visited);
                dfs(x, y + 1, grid, t, visited);
            }
        }

        public boolean isValid(int x, int y) {
            if(x < 0 || x >= m || y < 0 || y >= n) {
                return false;
            }
            return true;
        }
    }
}
