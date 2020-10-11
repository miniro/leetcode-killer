public class O55 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        boolean tag = true;

        public boolean isBalanced(TreeNode root) {
            travel(root);
            return tag;
        }

        void travel(TreeNode root) {
            if(root != null) {
                if(Math.abs(getBalanceVal(root)) > 1) {
                    tag = false;
                }
                travel(root.left);
                travel(root.right);
            }
        }

        int getLength(TreeNode root) {
            if(root == null)
                return 0;
            return Math.max(getLength(root.left), getLength(root.right)) + 1;
        }

        int getBalanceVal(TreeNode root) {
            return getLength(root.left) - getLength(root.right);
        }
    }
}
