import java.util.Arrays;

public class T455 {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int index1 = 0, index2 = 0;
            while(index2 != s.length && index1 != g.length) {
                if(g[index1] <= s[index2]) {
                    index1 ++;
                    index2 ++;
                } else {
                    index2 ++;
                }
            }
            return index1;
        }
    }
}
