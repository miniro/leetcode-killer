import java.util.HashMap;
import java.util.Map;

public class T1373 {

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
        int ans = 0;
        public int maxSumBST(TreeNode root) {
            travel(root);
            return ans;
        }

        public void travel(TreeNode root) {
            if(root != null) {
                if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                    int sum = getSum(root);
                    ans = Math.max(ans, sum);
                    return;
                }
                travel(root.left);
                travel(root.right);
            }
        }

        public boolean isBST(TreeNode root, int minV, int maxV) {
            if(root == null) {
                return true;
            }
            if(root.val <= minV || root.val >= maxV) {
                return false;
            }
            return isBST(root.left, minV, root.val) && isBST(root.right, root.val, maxV);
        }

        public int getSum(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int sum = root.val + getSum(root.left) + getSum(root.right);
            ans = Math.max(ans, sum);
            return sum;
        }
    }
}
