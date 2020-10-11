import java.util.ArrayList;
import java.util.List;

public class T78 {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            dfs(0, nums);
            return result;
        }

        public void dfs(int index, int[] nums) {
            if(index > nums.length) {
                return;
            }
            if(index == nums.length) {
                result.add(new ArrayList<>(tmp));
                return;
            }
            tmp.add(nums[index]);
            dfs(index + 1, nums);
            tmp.remove(tmp.size() - 1);
            dfs(index + 1, nums);
        }
    }
}
