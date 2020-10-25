public class T392 {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            if(s.length() == 0) {
                return true;
            }
            if(s.length() > t.length()) {
                return false;
            }
            int index1 = 0, index2 = 0;
            while(index2 < t.length()) {
                if(s.charAt(index1) == t.charAt(index2)) {
                    index1 ++;
                    if(index1 == s.length()) {
                        return true;
                    }
                }
                index2 ++;
            }
            return false;
        }
    }
}
