import java.util.Arrays;

public class T376 {
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] dp1 = new int[nums.length];
            int[] dp2 = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp1[j] % 2 == 1) {
                        if (nums[i] > nums[j]) {
                            dp1[i] = Math.max(dp1[i], dp1[j]);
                        }
                    } else {
                        if (nums[i] < nums[j]) {
                            dp1[i] = Math.max(dp1[i], dp1[j]);
                        }
                    }
                    if (dp2[j] % 2 == 1) {
                        if (nums[i] < nums[j]) {
                            dp2[i] = Math.max(dp2[i], dp2[j]);
                        }
                    } else {
                        if (nums[i] > nums[j]) {
                            dp2[i] = Math.max(dp2[i], dp2[j]);
                        }
                    }
                }
                dp1[i]++;
                dp2[i]++;
            }
            return Math.max(dp1[nums.length - 1], dp2[nums.length - 1]);
        }
    }

}