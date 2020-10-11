import java.util.HashSet;
import java.util.Set;

public class T771 {
    class Solution {
        public int numJewelsInStones(String J, String S) {
            Set<Character> set = new HashSet<>();
            for(char c : J.toCharArray()) {
                set.add(c);
            }
            int cnt = 0;
            for(char c : S.toCharArray()) {
                if(set.contains(c)) {
                    cnt ++;
                }
            }
            return cnt;
        }
    }
}
