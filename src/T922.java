import java.util.ArrayList;
import java.util.List;

public class T922 {
    class Solution {
        public int[] sortArrayByParityII(int[] A) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            int[] result = new int[A.length];
            int k = 0;
            for(int val : A) {
                if(val % 2 == 0) {
                    list2.add(val);
                } else {
                    list1.add(val);
                }
            }
            for(int i=0;i<list1.size();i++) {
                result[k++] = list2.get(i);
                result[k++] = list1.get(i);
            }
            return result;
        }
    }
}
