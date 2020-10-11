public class T439 {
    class Solution {
        public int reversePairs(int[] nums) {
            int cnt = 0;
            for(int i=0;i<nums.length-1;i++) {
                for(int j=i+1;j<nums.length;j++) {
                    if(nums[i] > 0) {
                        if(nums[j] > 0) {
                            if(nums[i] / 2 > nums[j] || nums[i] / 2 == nums[j] && nums[i] % 2 == 1) {
                                cnt ++;
                            }
                        } else {
                            cnt ++;
                        }
                    } else if (nums[i] == 0) {
                        if(nums[j] < 0) {
                            cnt ++;
                        }
                    } else {
                        if(nums[j] < 0) {
                            int a = Math.abs(nums[i]);
                            int b = Math.abs(nums[j]);
                            if(a / 2 < b) {
                                cnt ++;
                            }
                        }
                    }
                }
            }
            return cnt;
        }
    }
}
