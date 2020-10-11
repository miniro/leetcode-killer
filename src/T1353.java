import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class T1353 {
    class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if(end != o.end) {
                return end - o.end;
            }
            return start - o.start;
        }
    }

    class Solution {
        public int maxEvents(int[][] events) {
            List<Meeting> list = new LinkedList<>();
            for(int[] event : events) {
                list.add(new Meeting(event[0], event[1]));
            }
            Collections.sort(list);
            int now = 1;
            int result = 0;
            while(list.size() > 0) {
                if(list.get(0).end >= now) {
                    if(list.get(0).start <= now) {
                        now ++;
                        result ++;
                    } else {
                        now = list.get(0).start + 1;
                        result ++;
                    }
                    list.remove(0);
                } else {
                    list.remove(0);
                }
            }
            return result;
        }
    }
}
