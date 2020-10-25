public class T529 {
    class Solution {
        int m, n;
        int[][] directions = new int[][]{
                {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
        };
        boolean[][] visited;
        char[][] board;
        public char[][] updateBoard(char[][] board, int[] click) {
            this.board = board;
            m = board.length;
            if(m == 0) {
                return board;
            }
            n = board[0].length;
            visited = new boolean[m][n];
            dfs(click[0], click[1]);
            return this.board;
        }

        public void dfs(int x, int y) {
            visited[x][y] = true;
            if(board[x][y] == 'M') {
                board[x][y] = 'X';
                return;
            }
            int num = numOfLandmine(x, y);
            if(num > 0) {
                board[x][y] = (char)(num + '0');
                return;
            }
            board[x][y] = 'B';
            for(int[] direction : directions) {
                if(isValid(x + direction[0], y + direction[1]) && !visited[x + direction[0]][y + direction[1]]) {
                    dfs(x + direction[0], y + direction[1]);
                }
            }
        }

        public int numOfLandmine(int x, int y) {
            int cnt = 0;
            for(int[] direction : directions) {
                if(isValid(x + direction[0], y + direction[1]) && board[x + direction[0]][y + direction[1]] == 'M') {
                    cnt ++;
                }
            }
            return cnt;
        }

        public boolean isValid(int x, int y) {
            return x >= 0 && x < m && y >= 0 && y < n;
        }
    }
}
