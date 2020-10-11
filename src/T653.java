import java.util.HashSet;
import java.util.Set;

public class T653 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        Set<Integer> set;
        boolean result;
        public Solution() {
            set = new HashSet<>();
            result = false;
        }

        public boolean findTarget(TreeNode root, int k) {
            travel(root, k);
            return result;
        }

        public void travel(TreeNode root, int k) {
            if(root != null) {
                if(set.contains(k - root.val)) {
                    result = true;
                }
                set.add(root.val);
                travel(root.left, k);
                travel(root.right, k);
            }
        }
    }
}
