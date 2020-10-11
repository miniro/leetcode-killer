import java.util.ArrayList;
import java.util.List;

public class T113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int sum;
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            this.sum = sum;
            dfs(root, 0);
            return ans;
        }

        public void dfs(TreeNode root, int sum) {
            if(root == null) {
                return;
            }
            tmp.add(root.val);
            if(root.left == null && root.right == null) {
                if(sum + root.val == this.sum) {
                    ans.add(new ArrayList<>(tmp));
                }
                tmp.remove(tmp.size() - 1);
                return;
            }
            dfs(root.left, sum + root.val);
            dfs(root.right, sum + root.val);
            tmp.remove(tmp.size() - 1);
        }
    }
}
