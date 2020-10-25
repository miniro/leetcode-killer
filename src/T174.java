public class T174 {
    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            if (dungeon.length == 0) {
                return 1;
            }
            int m = dungeon.length;
            int n = dungeon[0].length;
            int[][] dp1 = new int[m][n];
            int[][] dp2 = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        dp1[i][j] = dp2[i][j] = dungeon[0][0];
                    } else if (i == 0) {
                        dp1[i][j] = dp1[i][j - 1] + dungeon[i][j];
                        dp2[i][j] = dungeon[i][j] > 0 ? dp2[i][j - 1] : dp1[i][j];
                    } else if (j == 0) {
                        dp1[i][j] = dp1[i - 1][j] + dungeon[i][j];
                        dp2[i][j] = dungeon[i][j] > 0 ? dp2[i - 1][j] : dp1[i][j];
                    } else {
                        if (dp2[i - 1][j] > dp2[i][j - 1]) {
                            dp1[i][j] = dp1[i - 1][j] + dungeon[i][j];
                            dp2[i][j] = Math.min(dp2[i - 1][j], dp1[i][j]);
                        } else {
                            dp1[i][j] = dp1[i][j - 1] + dungeon[i][j];
                            dp2[i][j] = Math.min(dp2[i][j - 1], dp1[i][j]);
                        }
                    }
                }
            }
            int row = 0;
            int col = 0;
            int minV = dp2[0][0];
            while (true) {
                if (row != m - 1 && col != n - 1) {
                    if (dp2[row + 1][col] > dp2[row][col + 1]) {
                        minV = Math.min(minV, dp2[++row][col]);
                    } else {
                        minV = Math.min(minV, dp2[row][++col]);
                    }
                } else if (row != m - 1) {
                    minV = Math.min(minV, dp2[++row][col]);
                } else if (col != n - 1) {
                    minV = Math.min(minV, dp2[row][++col]);
                } else {
                    break;
                }
            }
            return minV >= 0 ? 1 : 1 - minV;
        }
    }
}
