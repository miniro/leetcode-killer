import java.util.TreeSet;

public class T220 {
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int n = nums.length;
            TreeSet<Long> treeSet = new TreeSet<>();
            for(int i = 0; i < n; i++) {
                if(i > k) {
                    treeSet.remove((long) nums[i - k - 1]);
                }
                Long min = treeSet.ceiling((long) nums[i] - t);
                if(min != null && min < nums[i] + t) {
                    return true;
                }
                treeSet.add((long) nums[i]);
            }
            return false;
        }
    }
}
