public class T1022 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        int result;

        public int sumRootToLeaf(TreeNode root) {
            dfs(root, 0);
            return result;
        }

        public void dfs(TreeNode root, int now) {
            if(root == null) {
                return;
            }
            if(root.left == null && root.right == null) {
                add(now * 2 + root.val);
                return;
            }
            if(root.left != null) {
                dfs(root.left, now * 2 + root.val);
            }
            if(root.right != null) {
                dfs(root.right, now * 2 + root.val);
            }
        }

        public void add(int val) {
            result = (result + val) % 1000000007;
        }
    }
}
