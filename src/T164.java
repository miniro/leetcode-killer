import java.util.Arrays;

public class T164 {
    class Solution {
        public int maximumGap(int[] nums) {
            Arrays.sort(nums);
            int val = 0;
            for(int i=0;i<nums.length-1;i++) {
                if(Math.abs(nums[i] - nums[i+1]) > val) {
                    val =Math.abs(nums[i] - nums[i+1]);
                }
            }
            return val;
        }
    }
}
