public class T106 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        int[] inorder;
        int[] postorder;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.inorder = inorder;
            this.postorder = postorder;
            return create(0, inorder.length - 1, 0, postorder.length - 1);
        }

        public TreeNode create(int inleft, int inright, int postleft, int postright) {
            if(inleft > inright) {
                return null;
            }
            int index = -1;
            for(int i = inleft; i <= inright; i ++) {
                if(inorder[i] == postorder[postright]) {
                    index = i;
                    break;
                }
            }
            TreeNode root = new TreeNode(postorder[postright]);
            root.left = create(inleft, index - 1, postleft, postleft + index - 1 - inleft);
            root.right = create(index + 1, inright, postright + index - inright,postright - 1);
            return root;
        }
    }
}
