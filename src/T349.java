import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class T349 {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for(int num : nums1) {
                set1.add(num);
            }
            for(int num : nums2) {
                set2.add(num);
            }
            set1.retainAll(set2);
            Iterator iterator = set1.iterator();
            int[] result = new int[set1.size()];
            int k = 0;
            while(iterator.hasNext()) {
                result[k++] = (int) iterator.next();
            }
            return  result;
        }
    }
}
