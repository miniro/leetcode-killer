import java.util.*;

public class T845 {
    class Solution {
        public int longestMountain(int[] A) {
            int ans = 0;
            int preStatus = -2, nowStatus;
            int preIndex = 0;
            List<Integer> list = new ArrayList<>();
            list.add(0);
            Map<String, Integer> map = new HashMap<>();
            for(int i = 1; i < A.length; i ++) {
                nowStatus = Integer.compare(A[i], A[i - 1]);
                if(preStatus == -2) {
                    preStatus = nowStatus;
                } else if(nowStatus != preStatus) {
                    list.add(i - 1);
                    map.put(preIndex + "-" + (i - 1), preStatus);
                    preIndex = i - 1;
                    preStatus = nowStatus;
                }
            }
            list.add(A.length - 1);
            map.put(preIndex + "-" + (A.length - 1), preStatus);
            for(int i = 2; i < list.size(); i ++) {
                int state1 = map.get(list.get(i - 2) + "-" + list.get(i - 1));
                int state2 = map.get(list.get(i - 1) + "-" + list.get(i));
                if(state1 == 1 && state2 == -1) {
                    ans = Math.max(ans, list.get(i) - list.get(i - 2) + 1);
                }
            }
            return ans;
        }
    }
}