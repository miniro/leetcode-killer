import java.util.Arrays;
import java.util.Comparator;

public class T452 {
    class Solution {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
            int ans = 0;
            int index = 0;
            while(index < points.length) {
                int last = points[index][1];
                ans ++;
                while(index < points.length && points[index][0] <= last) {
                    index ++;
                }
            }
            return ans;
        }
    }
}
