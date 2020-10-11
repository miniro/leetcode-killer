public class T404 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        int result;

        public Solution() {
            result = 0;
        }

        public void travel(TreeNode root) {
            if(root != null) {
                if(root.left != null && root.left.left == null && root.left.right == null) {
                    result += root.left.val;
                }
                travel(root.left);
                travel(root.right);
            }
        }

        public int sumOfLeftLeaves(TreeNode root) {
            travel(root);
            return result;
        }
    }
}
