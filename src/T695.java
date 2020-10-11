public class T695 {
    class Solution {
        int m;
        int n;
        int maxArea;
        int area;
        boolean[][] visited;

        public int maxAreaOfIsland(int[][] grid) {
            if(grid.length == 0) {
                return 0;
            }
            m = grid.length;
            n = grid[0].length;
            visited = new boolean[m][n];
            area = 0;
            maxArea = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j] && grid[i][j] == 1) {
                        area = 0;
                        dfs(i, j, grid);
                        if(area > maxArea) {
                            maxArea = area;
                        }
                    }
                }
            }
            return maxArea;
        }

        public void dfs(int x, int y, int[][] grid) {
            visited[x][y] = true;
            area ++;
            if(isValid(x + 1, y) && !visited[x + 1][y] && grid[x + 1][y] == 1) {
                dfs(x + 1, y, grid);
            }
            if(isValid(x - 1, y) && !visited[x - 1][y] && grid[x - 1][y] == 1) {
                dfs(x - 1, y, grid);
            }
            if(isValid(x, y + 1) && !visited[x][y + 1] && grid[x][y + 1] == 1) {
                dfs(x, y + 1, grid);
            }
            if(isValid(x, y - 1) && !visited[x][y - 1] && grid[x][y - 1] == 1) {
                dfs(x, y - 1, grid);
            }
        }

        public boolean isValid(int x, int y) {
            if(x < 0 || x >= m) {
                return false;
            }
            if(y < 0 || y >= n) {
                return false;
            }
            return true;
        }
    }
}
