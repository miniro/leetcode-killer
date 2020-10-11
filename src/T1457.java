import java.util.ArrayList;
import java.util.List;

public class T1457 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        int cnt;
        List<Integer> path;

        public int pseudoPalindromicPaths (TreeNode root) {
            cnt = 0;
            path = new ArrayList<>();
            if(root != null) {
                travel(root);
            }
            return cnt;
        }

        public void travel(TreeNode root) {
            path.add(root.val);
            if(root.left == null && root.right == null) {
                int[] arr = new int[10];
                for(int element : path) {
                    arr[element] ++;
                }
                int odsNum = 0;
                for(int i = 1; i < 10; i ++) {
                    if(arr[i] % 2 == 1) {
                        odsNum ++;
                    }
                }
                if(odsNum <= 1) {
                    cnt ++;
                }
            }
            if(root.left != null) {
                travel(root.left);
                path.remove(path.size() - 1);
            }
            if(root.right != null) {
                travel(root.right);
                path.remove(path.size() - 1);
            }
        }
    }
}
