import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            int[] ans = new int[2];
            for (int index = 0; index < nums.length; index++) {
                if (map.containsKey(nums[index])) {
                    map.get(nums[index]).add(index);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(index);
                    map.put(nums[index], list);
                }
            }
            for (int key : map.keySet()) {
                if (!map.containsKey(target - key)) {
                    continue;
                }
                if (key * 2 == target) {
                    ans[0] = map.get(key).get(0);
                    ans[1] = map.get(key).get(1);
                } else {
                    ans[0] = map.get(key).get(0);
                    ans[1] = map.get(target - key).get(0);
                }
                break;
            }
            return ans;
        }
    }
}
