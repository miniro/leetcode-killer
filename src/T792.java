import java.util.*;

public class T792 {
    class Solution {
        public int numMatchingSubseq(String S, String[] words) {
            Map<Character, List<String>> map = new HashMap<>();
            for (String word : words) {
                Character c = word.charAt(0);
                if (!map.containsKey(c)) {
                    map.put(c, new ArrayList<>());
                }
                map.get(c).add(word);
            }
            for (char c : S.toCharArray()) {
                if (!map.containsKey(c)) {
                    continue;
                }
                List<String> list = new ArrayList<>(map.get(c));
                map.remove(c);
                for (String string : list) {
                    if (string.length() > 1) {
                        Character character = string.charAt(1);
                        if (!map.containsKey(character)) {
                            map.put(character, new ArrayList<>());
                        }
                        map.get(character).add(string.substring(1));
                    }
                }
            }
            int cnt = 0;
            for (Character c : map.keySet()) {
                cnt += map.get(c).size();
            }
            return words.length - cnt;
        }
    }
}