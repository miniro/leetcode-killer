import java.util.Arrays;

public class T560 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int ans = 0;
            int[] arr = new int[nums.length + 1];
            for(int i = 0; i < nums.length; i ++) {
                arr[i + 1] = arr[i] + nums[i];
            }
            for(int i = 1; i < arr.length; i ++) {
                int left = 0;
                int right = i - 1;
                while(left <= right) {
                    int mid = (left + right) / 2;
                    if(arr[i] - arr[mid] == k) {
                        ans ++;
                        break;
                    } else if(arr[i] - arr[mid] > k) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return ans;
        }
    }
}
