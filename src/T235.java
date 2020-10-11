import java.util.*;

public class T235 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Set<TreeNode> set = new HashSet<>();
            Stack<TreeNode> stack = new Stack<>();
            if(root == null) {
                return null;
            }
            TreeNode node = root;
            while(node != null) {
                set.add(node);
                if(node.val < p.val) {
                    node = node.right;
                } else if(node.val > p.val) {
                    node = node.left;
                } else {
                    break;
                }
            }
            node = root;
            while(node != null) {
                stack.add(node);
                if(node.val < q.val) {
                    node = node.right;
                } else if(node.val > q.val) {
                    node = node.left;
                } else {
                    break;
                }
            }
            while(!stack.empty()) {
                TreeNode value = stack.pop();
                if(set.contains(value)) {
                    return value;
                }
            }
            return root;
        }

    }
}
