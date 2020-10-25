import java.util.Arrays;
import java.util.Comparator;

public class T435 {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if(intervals.length == 0) {
                return 0;
            }
            int ans = 0;
            Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
            int last = intervals[0][1];
            for(int i = 1; i < intervals.length; i ++) {
                if(intervals[i][1] <= last) {
                    ans ++;
                    last = intervals[i][1];
                } else if(intervals[i][0] >= last) {
                    last = intervals[i][1];
                } else {
                    ans ++;
                }
            }
            return ans;
        }
    }
}
