public class T130 {
    class Solution {
        int m;
        int n;
        boolean[][] visited;
        char[][] board;

        public void solve(char[][] board) {
            if(board.length == 0) {
                return;
            }
            this.board = board;
            m = board.length;
            n = board[0].length;
            visited = new boolean[m][n];
            for(int i=0;i<n;i++) {
                if(!visited[0][i] && board[0][i] == 'O') {
                    dfs(0, i);
                }
                if(!visited[m-1][i] && board[m-1][i] == 'O') {
                    dfs(m-1, i);
                }
            }
            for(int j=0;j<m;j++) {
                if(!visited[j][0] && board[j][0] == 'O') {
                    dfs(j, 0);
                }
                if(!visited[j][n-1] && board[j][n-1] == 'O') {
                    dfs(j, n-1);
                }
            }
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(visited[i][j]) {
                        board[i][j] = 'O';
                    } else {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        public void dfs(int x, int y) {
            visited[x][y] = true;
            if(isValid(x-1, y) && !visited[x-1][y] && board[x-1][y] == 'O') {
                dfs(x-1, y);
            }
            if(isValid(x+1, y) && !visited[x+1][y] && board[x+1][y] == 'O') {
                dfs(x+1, y);
            }
            if(isValid(x, y+1) && !visited[x][y+1] && board[x][y+1] == 'O') {
                dfs(x, y+1);
            }
            if(isValid(x, y-1) && !visited[x][y-1] && board[x][y-1] == 'O') {
                dfs(x, y-1);
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
