public class T79 {
    class StopMsgException extends Exception {

    }

    class Solution {
        int n, m;
        char[][] board;
        boolean ans;
        boolean[][] visited;

        public boolean exist(char[][] board, String word) {
            m = board.length;
            n = board[0].length;
            this.board = board;
            visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        try {
                            dfs(word, 0, i, j);
                        } catch (StopMsgException e) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public void dfs(String word, int index, int x, int y) throws StopMsgException {
            if (x < 0 || x >= m || y < 0 || y >= n || index >= word.length() ||
                    visited[x][y] || word.charAt(index) != board[x][y]) {
                return;
            }
            if (index == word.length() - 1) {
                ans = true;
                throw new StopMsgException();
            }
            visited[x][y] = true;
            dfs(word, index + 1, x + 1, y);
            dfs(word, index + 1, x - 1, y);
            dfs(word, index + 1, x, y + 1);
            dfs(word, index + 1, x, y - 1);
            visited[x][y] = false;
        }
    }
}