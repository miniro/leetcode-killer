import java.util.Arrays;
import java.util.Comparator;

public class T1024 {
    class Solution {
        public int videoStitching(int[][] clips, int T) {
            Arrays.sort(clips, (o1, o2) -> {
                if(o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            });
            int ans = 0;
            int index = 0;
            int maxLast = 0;
            while(index < clips.length) {
                int last = maxLast;
                if(clips[index][0] <= last) {
                    while(index < clips.length && clips[index][0] <= last) {
                        maxLast = Math.max(maxLast, clips[index][1]);
                        index ++;
                    }
                } else {
                    index ++;
                }
                ans ++;
                if(maxLast >= T) {
                    break;
                }
            }
            return maxLast >= T ? ans : -1;
        }
    }
}