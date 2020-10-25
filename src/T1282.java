import java.util.ArrayList;
import java.util.List;

public class T1282 {
    class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            List<List<Integer>> lists = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            for(int i = 0; i <= groupSizes.length; i ++) {
                List<Integer> list = new ArrayList<>();
                lists.add(list);
            }
            for(int i = 0; i < groupSizes.length; i ++) {
                lists.get(groupSizes[i]).add(i);
            }
            for(int i = 1; i <= groupSizes.length; i ++) {
                List<Integer> tmp = new ArrayList<>();
                int index = 0;
                while(index < lists.get(i).size()) {
                    while(tmp.size() < i) {
                        tmp.add(lists.get(i).get(index));
                        index ++;
                    }
                    ans.add(new ArrayList<>(tmp));
                    tmp.clear();
                }
            }
            return ans;
        }
    }
}
