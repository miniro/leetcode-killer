public class T1111 {
    class Solution {
        public int[] maxDepthAfterSplit(String seq) {
            int[] depth = new int[seq.length()];
            int[] ans = new int[seq.length()];
            int maxDepth = 0;
            int now = 1;
            for(int i = 0; i < seq.length(); i ++) {
                depth[i] = seq.charAt(i) == '(' ? now ++ : -- now;
                maxDepth = Math.max(maxDepth, depth[i]);
            }
            for(int i = 0; i < seq.length(); i ++) {
                ans[i] = depth[i] > maxDepth / 2 ? 0 : 1;
            }

            return ans;
        }
    }
}