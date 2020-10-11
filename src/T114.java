import java.util.ArrayList;
import java.util.List;

public class T114 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        List<TreeNode> list = new ArrayList<>();

        public void flatten(TreeNode root) {
            preOrder(root);
            TreeNode head = new TreeNode();
            TreeNode p = head;
            for (TreeNode node : list) {
                node.left = node.right = null;
                p.right = node;
                p = p.right;
            }
            p.right = null;
            root = head.right;
        }

        public void preOrder(TreeNode root) {
            if (root != null) {
                list.add(root);
                preOrder(root.left);
                preOrder(root.right);
            }
        }
    }
}