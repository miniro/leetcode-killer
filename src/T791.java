import java.util.*;

public class T791 {
    class Solution {
        class ComparatorT implements Comparable<ComparatorT> {
            Character character;

            ComparatorT(Character c) {
                character = c;
            }

            @Override
            public int compareTo(ComparatorT o) {
                return rank[character - 'a'] - rank[o.character - 'a'];
            }
        }

        int[] rank;
        public String customSortString(String S, String T) {
            rank = new int[26];
            for(int i = 0; i < S.length(); i++) {
                rank[S.charAt(i) - 'a'] = i;
            }
            List<ComparatorT> list = new ArrayList<>();
            for(Character c : T.toCharArray()) {
                list.add(new ComparatorT(c));
            }
            Collections.sort(list);
            StringBuilder stringBuilder = new StringBuilder();
            for(ComparatorT element : list) {
                stringBuilder.append(element.character);
            }
            return stringBuilder.toString();
        }
    }
}
