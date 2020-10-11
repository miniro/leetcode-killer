import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length < 2) {
                return intervals;
            }
            List<int[]> result = new ArrayList<>();
            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
            int start = intervals[0][0];
            int end = intervals[0][1];
            for(int i=1;i<intervals.length;i++) {
                if(intervals[i][1] > end) {
                    if(intervals[i][0] > end) {
                        result.add(new int[]{start, end});
                        start = intervals[i][0];
                        end = intervals[i][1];
                    } else {
                        end = intervals[i][1];
                    }
                }
            }
            result.add(new int[]{start, end});
            return result.toArray(new int[result.size()][2]);
        }
    }
}
