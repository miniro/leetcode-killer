import java.util.ArrayList;
import java.util.List;

public class T538 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        List<Integer> list = new ArrayList<>();
        int k = 0;
        Integer[] arr;
        public TreeNode convertBST(TreeNode root) {
            travel(root);
            arr = list.toArray(new Integer[list.size()]);
            for(int i = arr.length - 2; i >= 0; i --) {
                arr[i] += arr[i + 1];
            }
            setValue(root);
            return root;
        }

        public void travel(TreeNode root) {
            if(root != null) {
                travel(root.left);
                list.add(root.val);
                travel(root.right);
            }
        }

        public void setValue(TreeNode root) {
            if(root != null) {
                setValue(root.left);
                root.val = arr[k ++];
                setValue(root.right);
            }
        }
    }
}
