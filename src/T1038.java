import java.util.Stack;

public class T1038 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        Stack<Integer> stack;
        public TreeNode bstToGst(TreeNode root) {
            stack = new Stack<>();
            reinorder(root);
            inorder(root);
            return root;
        }

        public void reinorder(TreeNode root) {
            if(root != null) {
                reinorder(root.right);
                int value = stack.empty() ? root.val : root.val + stack.peek();
                stack.push(value);
                reinorder(root.left);
            }
        }

        public void inorder(TreeNode root) {
            if(root != null) {
                inorder(root.left);
                root.val = stack.pop();
                inorder(root.right);
            }
        }
    }
}
