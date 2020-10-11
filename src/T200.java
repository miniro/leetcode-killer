public class T200 {
    class Solution {
        int m, n;
        char[][] grid;
        int[][] directions = new int[][]{
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        public int numIslands(char[][] grid) {
            if(grid.length == 0) {
                return 0;
            }
            m = grid.length;
            n = grid[0].length;
            int ans = 0;
            this.grid = grid;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        dfs(i, j);
                        ans++;
                    }
                }
            }
            return ans;
        }

        public void dfs(int x, int y) {
            if (!isValid(x, y) || grid[x][y] == '0') {
                return;
            }
            grid[x][y] = '0';
            for (int[] direction : directions) {
                dfs(x + direction[0], y + direction[1]);
            }
        }

        public boolean isValid(int x, int y) {
            return x >= 0 && x < m && y >= 0 && y < n;
        }
    }

}