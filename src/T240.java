public class T240 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix.length == 0) {
                return false;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int x = m - 1;
            int y = 0;
            while(x >= 0 && x < m && y >= 0 && y < n) {
                if(matrix[x][y] == target) {
                    return true;
                } else if(matrix[x][y] > target) {
                    x --;
                } else {
                    y ++;
                }
            }
            return false;
        }
    }
}
