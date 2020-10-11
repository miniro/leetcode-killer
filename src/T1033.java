import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T1033 {
    class Solution {
        public int[] numMovesStones(int a, int b, int c) {
            List<Integer> list = new ArrayList<>();
            int[] result = new int[2];
            list.add(a);
            list.add(b);
            list.add(c);
            Collections.sort(list);
            if(list.get(1) - list.get(0) == 1 && list.get(2) - list.get(1) == 1) {
                result[0] = result[1] = 0;
            } else if(list.get(1) - list.get(0) <= 2 || list.get(2) - list.get(1) <= 2) {
                result[0] = 1;
            } else {
                result[0] = 2;
            }
            result[1] = list.get(2) - list.get(0) - 2;
            return result;
        }
    }
}
