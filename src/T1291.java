import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T1291 {
    class Solution {
        public List<Integer> sequentialDigits(int low, int high) {
            List<Integer> list = new ArrayList<>();
            for (int step = 2; step < 10; step++) {
                for (int i = 1; i + step - 1 < 10; i++) {
                    int result = 0;
                    for (int j = 0; j < step; j++) {
                        result = result * 10 + i + j;
                    }
                    list.add(result);
                }
            }
            int left = Collections.binarySearch(list, low);
            left = left < 0 ? Math.abs(left) - 1 : left;
            int right = Collections.binarySearch(list, high);
            right = right < 0 ? Math.abs(right) - 1 : right + 1;
            return list.subList(left, right);
        }
    }
}
