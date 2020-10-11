import java.util.Arrays;
import java.util.Random;

public class T528 {
    class Solution {
        int sum;
        int[] arr;

        public Solution(int[] w) {
            sum = 0;
            arr = new int[w.length];
            Arrays.sort(w);
            arr[0] = 0;
            sum = w[0];
            for (int i = 1; i < w.length; i++) {
                arr[i] = arr[i - 1] + w[i - 1];
                sum += w[i];
            }
        }

        public int pickIndex() {
            Random random = new Random();
            int num = random.nextInt(sum);
            // System.out.println("num " + num);
            int index = Arrays.binarySearch(arr, num);
            // System.out.println("index " + index);
            return index >= 0 ? index : Math.abs(index) - 2;
        }
    }
}