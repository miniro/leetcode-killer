public class T112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        int sum;
        boolean result;

        public boolean hasPathSum(TreeNode root, int sum) {
            this.sum = sum;
            result = false;
            if(root != null) {
                dfs(root, 0);
            }
            return result;
        }

        public void dfs(TreeNode root, int now) {
            if(root.left == null && root.right == null) {
                if(now + root.val == sum) {
                    result = true;
                }
            }
            if(root.left != null) {
                dfs(root.left, now + root.val);
            }
            if(root.right != null) {
                dfs(root.right, now + root.val);
            }
        }
    }
}
