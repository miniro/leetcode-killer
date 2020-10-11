import java.util.ArrayList;
import java.util.List;

public class T513 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        int maxDepth = 0;
        List<Integer> list = new ArrayList<>();
        public int findBottomLeftValue(TreeNode root) {
            dfs(root, 0);
            return list.get(list.size() - 1);
        }

        public void dfs(TreeNode root, int depth) {
            if(root == null) {
                return;
            }
            maxDepth = Math.max(maxDepth, depth);
            if(depth >= list.size()) {
                list.add(root.val);
            } else {
                list.set(depth, root.val);
            }
            dfs(root.right, depth + 1);
            dfs(root.left, depth + 1);
        }
    }
}
