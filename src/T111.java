public class T111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        int minDepth = 0x7fffffff;
        public int minDepth(TreeNode root) {
            if(root != null) {
                dfs(root, 1);
            }
            return minDepth == 0x7fffffff ? 0 : minDepth;
        }

        public void dfs(TreeNode root, int depth) {
            if(root.left == null && root.right == null) {
                if(depth < minDepth) {
                    minDepth = depth;
                }
            }
            if(root.left != null) {
                dfs(root.left, depth + 1);
            }
            if(root.right != null) {
                dfs(root.right, depth + 1);
            }
        }
    }
}
