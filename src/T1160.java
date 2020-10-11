public class T1160 {
    class Solution {
        public int countCharacters(String[] words, String chars) {
            int[] dict = new int[26];
            int result = 0;
            for(char c : chars.toCharArray()) {
                dict[c - 'a'] ++;
            }
            for(String word : words) {
                int[] tmpDict = dict.clone();
                boolean tag = true;
                for(char c : word.toCharArray()) {
                    tmpDict[c - 'a'] --;
                    if(tmpDict[c - 'a'] < 0) {
                        tag = false;
                        break;
                    }
                }
                if(tag) {
                    result += word.length();
                }
            }
            return result;
        }
    }
}
