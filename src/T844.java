public class T844 {
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            StringBuilder s1 = handle(S);
            StringBuilder s2 = handle(T);
            return s1.toString().equals(s2.toString());
        }

        public StringBuilder handle(String S) {
            StringBuilder result = new StringBuilder();
            for(char c : S.toCharArray()) {
                if(c == '#' && result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                } else if(c != '#') {
                    result.append(c);
                }
            }
            return result;
        }
    }
}
