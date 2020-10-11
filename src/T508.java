import java.util.*;
import java.util.stream.Collectors;

public class T508 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    class MapValueComparator implements Comparator<Map.Entry<Integer, Integer>> {
//        @Override
//        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//            return o2.getValue() - o1.getValue();
//        }
//    }

    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        public int[] findFrequentTreeSum(TreeNode root) {
            getSum(root);
            List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
            int maxV = Integer.MIN_VALUE;
            int cnt = 0;
            for(Map.Entry<Integer, Integer> entry : entryList) {
                if(entry.getValue() > maxV) {
                    maxV = entry.getValue();
                    cnt = 1;
                } else if (entry.getValue() == maxV){
                    cnt ++;
                }
            }
            int[] ans = new int[cnt];
            int k = 0;
            for(Map.Entry<Integer, Integer> entry : entryList) {
                if(entry.getValue() == maxV) {
                    ans[k ++] = entry.getKey();
                }
            }
            return ans;
        }

        public int getSum(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int sum = root.val + getSum(root.left) + getSum(root.right);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return sum;
        }
    }
}
