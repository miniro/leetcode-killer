public class T98 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        boolean result;
        int nowMax;

        public Solution() {
            result = true;
            nowMax = -2147483648;
        }

        public void travel(TreeNode node) {
            if(node != null) {
                travel(node.left);
                if(node.val <= nowMax) {
                    result = false;
                } else {
                    nowMax = node.val;
                }
                travel(node.right);
            }
        }

        public boolean isValidBST(TreeNode root) {
            travel(root);
            return result;
        }
    }
}
