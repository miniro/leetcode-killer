public class T152 {
    class Solution {
        public int maxProduct(int[] nums) {
            int maxV = nums[0];
            int minV = nums[0];
            int ans = nums[0];
            for(int i = 1; i < nums.length; i ++) {
                if(nums[i] < 0) {
                    int tmp = maxV;
                    maxV = minV;
                    minV = tmp;
                }
                maxV = Math.max(maxV * nums[i], nums[i]);
                minV = Math.min(minV * nums[i], nums[i]);
                ans = Math.max(ans, maxV);
            }
            return ans;
        }
    }
}
