import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O5 {
    class Solution {
        public String replaceSpace(String s) {
            StringBuilder result = new StringBuilder();
            for(char c : s.toCharArray()) {
                if(c == ' ') {
                    result.append("%20");
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        }
    }
}
