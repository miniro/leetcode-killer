import java.util.Arrays;

public class T1486 {
    class Solution {
        public int xorOperation(int n, int start) {
            int[] nums = new int[n];
            for(int i = 0; i < n; i ++) {
                nums[i] = start + i * 2;
            }
            return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
        }
    }
}
