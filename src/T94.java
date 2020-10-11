import java.util.ArrayList;
import java.util.List;

public class T94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        List<Integer> list;

        public List<Integer> inorderTraversal(TreeNode root) {
            list = new ArrayList<>();
            travel(root);
            return list;
        }

        public void travel(TreeNode root) {
            if(root != null) {
                travel(root.left);
                list.add(root.val);
                travel(root.right);
            }
        }
    }
}
