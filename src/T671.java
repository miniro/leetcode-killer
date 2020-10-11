public class T671 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        int min1;
        int min2;

        public Solution() {
            min1 = min2 = -1;
        }

        public void travel(TreeNode root) {
            if(root != null) {
                if(min1 == -1) {
                    min1 = root.val;
                } else {
                    if(root.val < min1) {
                        min2 = min1;
                        min1 = root.val;
                    }
                    else if(root.val > min1 && (min2 == -1 || root.val < min2)) {
                        min2 = root.val;
                    }
                }
                travel(root.left);
                travel(root.right);
            }
        }

        public int findSecondMinimumValue(TreeNode root) {
            travel(root);
            return min2;
        }
    }
}
