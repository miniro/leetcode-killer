import java.util.ArrayList;
import java.util.List;

public class T145 {
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            travel(root, ans);
            return ans;
        }

        public void travel(TreeNode root, List<Integer> ans) {
            if(root != null) {
                travel(root.left, ans);
                travel(root.right, ans);
                ans.add(root.val);
            }
        }
    }
}
