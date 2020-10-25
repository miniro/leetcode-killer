public class T530 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        boolean visited = false;
        int pre = 0;
        int ans = Integer.MAX_VALUE;
        public int getMinimumDifference(TreeNode root) {
            travel(root);
            return ans;
        }

        public void travel(TreeNode root) {
            if(root != null) {
                travel(root.left);
                if(visited) {
                    ans = Math.min(ans, root.val - pre);
                } else {
                    visited = true;
                }
                pre = root.val;
                travel(root.right);
            }
        }
    }
}
