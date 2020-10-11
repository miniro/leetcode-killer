import java.util.ArrayList;
import java.util.List;

public class T955 {
    class Solution {
        public int minDeletionSize(String[] A) {
            if (A.length <= 1) {
                return 0;
            }
            int ans = 0;
            boolean[] selected = new boolean[A[0].length()];
            List<String> list = new ArrayList<>();
            for (int i = 0; i < A[0].length(); i++) {
                list.clear();
                for (String s : A) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int j = 0; j <= i; j++) {
                        if (!selected[j]) {
                            stringBuilder.append(s.charAt(j));
                        }
                    }
                    list.add(stringBuilder.toString());
                }
                if (!judge(list)) {
                    selected[i] = true;
                    ans++;
                }
            }
            return ans;
        }

        public boolean judge(List<String> list) {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).compareTo(list.get(i - 1)) < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
