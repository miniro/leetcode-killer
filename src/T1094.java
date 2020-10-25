import java.util.Arrays;
import java.util.Comparator;

public class T1094 {
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            Arrays.sort(trips, Comparator.comparingInt(x -> x[1]));
            for(int i = 1; i <= 1000; i ++) {
                int nowCapacity = capacity;
                for (int[] trip : trips) {
                    if (trip[1] < i && i <= trip[2]) {
                        nowCapacity -= trip[0];
                    }
                    if (nowCapacity < 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
