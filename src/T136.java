import java.util.Arrays;

public class T136 {
    class Solution {
        public int singleNumber(int[] nums) {
            return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
        }
    }
}
