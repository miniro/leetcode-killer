import java.util.List;

public class T1301 {
    class Solution {
        int ans = 0;
        int n, maxV = 0;
        int[][] graph;
        boolean[][] visited;
        int[][] directions = new int[][]{
                {-1, -1}, {-1, 0}, {0, -1}
        };
        public int[] pathsWithMaxScore(List<String> board) {
            n = board.size();
            graph = new int[n][n];
            visited = new boolean[n][n];
            for(int i = 0; i < n; i ++) {
                for(int j = 0; j < n; j ++) {
                    switch (board.get(i).charAt(j)) {
                        case 'E': case 'S': graph[i][j] = 0;break;
                        case 'X': graph[i][j] = -1;break;
                        default: graph[i][j] = board.get(i).charAt(j) - '0';break;
                    }
                }
            }
            dfs(n-1, n-1, 0);
            return new int[]{maxV, ans};
        }

        public void dfs(int x, int y, int sum) {
            if(!isValid(x, y) || graph[x][y] == -1 || visited[x][y]) {
                return;
            }
            visited[x][y] = true;
            if(x == 0 && y == 0) {
                if(sum + graph[x][y] > maxV) {
                    maxV = sum + graph[x][y];
                    ans = 1;
                } else if(sum + graph[x][y] == maxV) {
                    ans ++;
                    ans %= 1000000007;
                }
            }
            for(int[] direction : directions) {
                dfs(x + direction[0], y + direction[1], sum + graph[x][y]);
            }
            visited[x][y] = false;
        }

        public boolean isValid(int x, int y) {
            return x >= 0 && x < n && y >= 0 && y < n;
        }
    }
}
