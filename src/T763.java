
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T763 {
    class Solution {
        public List<Integer> partitionLabels(String S) {
            List<Integer> ans = new ArrayList<>();
            int[] minIndex = new int[26];
            int[] maxIndex = new int[26];
            Arrays.fill(minIndex, -1);
            for(int i = 0; i < S.length(); i ++) {
                int index = S.charAt(i) - 'a';
                if(minIndex[index] == -1) {
                    minIndex[index] = i;
                }
                maxIndex[index] = i;
            }
            int nowI = 0, maxI = maxIndex[S.charAt(0) - 'a'], pre = -1;
            while(true) {
                while(nowI <= maxI) {
                    maxI = Math.max(maxI, maxIndex[S.charAt(nowI) - 'a']);
                    nowI ++;
                }
                ans.add(maxI - pre);
                pre = maxI;
                if(maxI == S.length() - 1) {
                    break;
                }
                maxI = maxIndex[S.charAt(nowI) - 'a'];
            }
            return ans;
        }
    }
}
