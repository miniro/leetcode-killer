public class T915 {
    class Solution {
        public int partitionDisjoint(int[] A) {
            int[] right = new int[A.length];
            int maxV = Integer.MIN_VALUE;
            int minV = Integer.MAX_VALUE;
            int ans = 0;
            for(int i = A.length - 1; i >= 0; i --) {
                minV = Math.min(minV, A[i]);
                right[i] = minV;
            }
            for(int i = 0; i < A.length - 1; i ++) {
                maxV = Math.max(maxV, A[i]);
                if(maxV <= right[i + 1]) {
                    ans = i + 1;
                    break;
                }
            }
            return ans;
        }
    }
}
