public class T226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            transfer(root);
            return root;
        }

        public void transfer(TreeNode root) {
            if(root == null) {
                return;
            }
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            transfer(root.left);
            transfer(root.right);
        }
    }
}
