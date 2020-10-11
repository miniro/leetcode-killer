import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T987 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class XyNode implements Comparable<XyNode>{
        int x;
        int y;
        int value;
        XyNode(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(XyNode o) {
            if(x != o.x) {
                return x - o.x;
            }
            if(y != o.y) {
                return o.y - y;
            }
            return value - o.value;
        }
    }

    class Solution {
        List<XyNode> list;

        public Solution() {
            list = new ArrayList<>();
        }

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            travel(root, 0 ,0);
            Collections.sort(list);
            int nowX = 0;
            boolean tag = false;
            List<Integer> tmp = new ArrayList<>();
            for(XyNode node : list) {
                if(!tag) {
                    nowX = node.x;
                    tmp.add(node.value);
                    tag = true;
                } else {
                    if(node.x == nowX) {
                        tmp.add(node.value);
                    } else {
                        List<Integer> newTmp = new ArrayList<>();
                        for(Integer value : tmp) {
                            newTmp.add(value);
                        }
                        result.add(newTmp);
                        nowX = node.x;
                        tmp.clear();
                        tmp.add(node.value);
                    }
                }
            }
            if(tmp.size() > 0) {
                result.add(tmp);
            }
            return result;
        }

        public void travel(TreeNode root, int x, int y) {
            if(root != null) {
                list.add(new XyNode(x, y, root.val));
                travel(root.left, x - 1, y - 1);
                travel(root.right, x + 1, y - 1);
            }
        }
    }
}
