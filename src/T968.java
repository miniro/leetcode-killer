public class T968 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public int minCameraCover(TreeNode root) {
            int[] ans = dfs(root);
            return ans[1];
        }

        public int[] dfs(TreeNode root) {
            if(root == null) {
                return new int[]{Integer.MAX_VALUE / 2, 0, 0};
            }
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            int[] ans = new int[3];
            ans[0] = left[2] + right[2] + 1;
            ans[1] = Math.min(ans[0], Math.min(left[0] + right[1], left[1] + right[0]));
            ans[2] = Math.min(ans[1], left[1] + right[1]);
            return ans;
        }
    }
}
