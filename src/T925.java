import java.util.ArrayList;
import java.util.List;

public class T925 {
    class Solution {
        public boolean isLongPressedName(String name, String typed) {
            List<int[]> list1 = createList(name);
            List<int[]> list2 = createList(typed);
            if (list1.size() != list2.size()) {
                return false;
            }
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i)[0] != list2.get(i)[0] || list1.get(i)[1] > list2.get(i)[1]) {
                    return false;
                }
            }
            return true;
        }

        public List<int[]> createList(String s) {
            List<int[]> ans = new ArrayList<>();
            int cnt = 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    cnt++;
                } else {
                    ans.add(new int[]{s.charAt(i - 1) - 'a', cnt});
                    cnt = 1;
                }
            }
            ans.add(new int[]{s.charAt(s.length() - 1) - 'a', cnt});
            return ans;
        }
    }
}
