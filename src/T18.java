import java.util.*;

public class T18 {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            Set<String> set = new HashSet<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum < target) {
                            left ++;
                        } else if (sum > target) {
                            right --;
                        } else {
                            List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            if(!set.contains(list.toString())) {
                                set.add(list.toString());
                                ans.add(list);
                            }
                            left ++;
                            right --;
                        }
                    }
                }
            }
            return ans;
        }
    }
}
