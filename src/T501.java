import java.util.ArrayList;
import java.util.List;

public class T501 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        int pre = -1;
        int maxCnt = 1;
        int nowCnt = 1;
        boolean tag = false;
        List<Integer> list = new ArrayList<>();
        public int[] findMode(TreeNode root) {
            inOrder(root);
            int[] ans = new int[list.size()];
            for(int i = 0; i < list.size(); i ++) {
                ans[i] = list.get(i);
            }
            return ans;
        }

        public void inOrder(TreeNode root) {
            if(root != null) {
                inOrder(root.left);
                if(tag) {
                    if(root.val == pre) {
                        nowCnt ++;
                        if(nowCnt > maxCnt) {
                            maxCnt = nowCnt;
                            list.clear();
                            list.add(root.val);
                        } else if(nowCnt == maxCnt) {
                            list.add(root.val);
                        }
                    } else {
                        nowCnt = 1;
                        if(maxCnt == 1) {
                            list.add(root.val);
                        }
                    }
                } else {
                    tag = true;
                    list.add(root.val);
                }
                pre = root.val;
                inOrder(root.right);
            }
        }
    }
}
