public class LCP19 {
    class Solution {
        public int minimumOperations(String leaves) {
            int ans = 0;
            if (leaves.charAt(0) == 'y') {
                ans++;
            }
            if (leaves.charAt(leaves.length() - 1) == 'y') {
                ans++;
            }
            int leftYIndex = -1, rightYIndex = -1;
            int YSum = 0, YMaxLen = 0, nowLen = 1;
            for (int i = 1; i < leaves.length() - 1; i++) {
                if (leaves.charAt(i) == 'y') {
                    leftYIndex = leftYIndex == -1 ? i : leftYIndex;
                    rightYIndex = i;
                    YSum++;
                    if (leaves.charAt(i - 1) == 'y') {
                        nowLen++;
                        YMaxLen = Math.max(YMaxLen, nowLen);
                    } else {
                        nowLen = 1;
                    }
                }
            }
            if (leftYIndex == -1) {
                return ans + 1;
            }
            ans += Math.min(rightYIndex - leftYIndex + 1 - YSum, YSum - YMaxLen);
            return ans;
        }
    }
}