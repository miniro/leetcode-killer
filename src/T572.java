public class T572 {
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
        boolean result;

        public boolean isSame(TreeNode p, TreeNode q) {
            if(p == null && q == null) {
                return true;
            }
            if(p == null || q == null) {
                return false;
            }
            return p.val == q.val && isSame(p.left, q.left) && isSame(p.right, q.right);
        }

        public void travel(TreeNode p, TreeNode q) {
            if(p != null) {
                if(isSame(p, q)) {
                    result = true;
                }
                travel(p.left, q);
                travel(p.right, q);
            }
        }

        public boolean isSubtree(TreeNode s, TreeNode t) {
            travel(s, t);
            return result;
        }
    }
}
