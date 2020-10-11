import java.util.Arrays;

public class T242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if(s.length() != t.length()) {
                return false;
            }
            int[] hash = new int[26];
            for(char c : s.toCharArray()) {
                hash[c - 'a'] ++;
            }
            for(char c : t.toCharArray()) {
                hash[c - 'a'] --;
                if(hash[c - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
