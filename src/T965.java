import java.util.HashSet;
import java.util.Set;

public class T965 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        Set<Integer> set;

        public Solution() {
            set = new HashSet<>();
        }

        public boolean isUnivalTree(TreeNode root) {
            travel(root);
            return set.size() == 1;
        }

        public void travel(TreeNode root) {
            if(root != null) {
                set.add(root.val);
                travel(root.left);
                travel(root.right);
            }
        }
    }
}
