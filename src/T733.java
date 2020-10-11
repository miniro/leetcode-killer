public class T733 {
    class Solution {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int nowColor;
        int[][] image;
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if(image.length == 0 || image[sr][sc] == newColor) {
                return image;
            }
            this.image = image;
            nowColor = image[sr][sc];
            dfs(sr, sc, newColor);
            return this.image;
        }

        public void dfs(int x, int y, int color) {
            image[x][y] = color;
            for(int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if(isValid(newX, newY) && image[newX][newY] == nowColor) {
                    dfs(newX, newY, color);
                }
            }
        }

        public boolean isValid(int x, int y) {
            return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
        }
    }
}
