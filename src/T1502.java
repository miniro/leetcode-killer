import java.util.Arrays;

public class T1502 {
    class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            Arrays.sort(arr);
            int value = arr[1] - arr[0];
            for(int i = 2; i < arr.length; i ++) {
                if(arr[i] - arr[i - 1] != value) {
                    return false;
                }
            }
            return true;
        }
    }
}
