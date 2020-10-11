public class T1300 {
    class Solution {
        public int findBestValue(int[] arr, int target) {
            int left = 0;
            int right = target;
            int minVal = 0x7fffffff;
            int minKey = 0;
            if(getSum(arr) <= target) {
                return getMax(arr);
            }
            while(left <= right) {
                int mid = (left + right) / 2;
                int sum = getSum(arr, mid);
                if(Math.abs(sum - target) < minVal) {
                    minKey = mid;
                    minVal = Math.abs(sum - target);
                } else if(Math.abs(sum - target) == minVal && mid < minKey) {
                    minKey = mid;
                }
                if(sum < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return minKey;
        }

        public int getSum(int[] arr, int k) {
            int sum = 0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] > k) {
                    sum += k;
                } else {
                    sum += arr[i];
                }
            }
            return sum;
        }

        public int getSum(int[] arr) {
            int sum = 0;
            for(int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            return sum;
        }

        public int getMax(int[] arr) {
            int maxV = 0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] > maxV) {
                    maxV = arr[i];
                }
            }
            return maxV;
        }

//        public static void main(String[] args) {
//            findBestValue(new int[]{4, 9, 3}, 10);
//        }
    }
}
