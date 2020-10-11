import java.util.Collections;

public class T667 {
    class Solution {
        public int[] constructArray(int n, int k) {
            int[] arr = new int[n];
            for(int i = 0; i < n; i ++) {
                arr[i] = i + 1;
            }
            for(int i = 1; i < k; i ++) {
                arr = reverse(arr, i, n);
            }
            return arr;
        }

        public int[] reverse(int[] arr, int left, int right) {
            int[] result = new int[arr.length];
            for(int i = 0; i < left; i ++) {
                result[i] = arr[i];
            }
            for(int i = left; i < right; i ++) {
                result[i] = arr[right - i + left - 1];
            }
            return result;
        }
    }
}
