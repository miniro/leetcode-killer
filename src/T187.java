import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T187 {
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> ans = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i <= s.length() - 10; i ++) {
                map.put(s.substring(i, i + 10), map.getOrDefault(s.substring(i, i + 10), 0) + 1);
            }
            for(String string : map.keySet()) {
                if(map.get(string) > 1) {
                    ans.add(string);
                }
            }
            return ans;
        }
    }
}
