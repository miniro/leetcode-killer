import java.util.Stack;

public class T84 {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int ans = 0;
            for(int i = 0; i < n; i ++) {
                int minH = Integer.MAX_VALUE;
                for(int j = i; j < n; j ++) {
                    minH = Math.min(minH, heights[j]);
                    ans = Math.max(ans, minH * (j + 1 - i));
                }
            }
            return ans;
        }
    }
}
