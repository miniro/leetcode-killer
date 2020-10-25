public class T1221 {
    class Solution {
        public int balancedStringSplit(String s) {
            int ans = 0;
            int leftNum = 0, rightNum = 0;
            for(char c : s.toCharArray()) {
                if(c == 'L') {
                    leftNum ++;
                } else {
                    rightNum ++;
                }
                if(leftNum == rightNum) {
                    leftNum = rightNum = 0;
                    ans ++;
                }
            }
            return ans;
        }
    }
}
