public class O39 {
    class Solution {
        public int majorityElement(int[] nums) {
            int cnt = 0;
            int val = 0;
            for(int x : nums) {
                if(cnt == 0) {
                    val = x;
                    cnt ++;
                } else if(x != val) {
                    cnt --;
                } else if(x == val) {
                    cnt ++;
                }
            }
            return val;
        }
    }
}
