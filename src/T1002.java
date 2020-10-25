import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T1002 {
    class Solution {
        public List<String> commonChars(String[] A) {
            List<String> ans = new ArrayList<>();
            int[] arr = new int[26];
            Arrays.fill(arr, Integer.MAX_VALUE);
            for(String s : A) {
                int[] a = new int[26];
                for(char c : s.toCharArray()) {
                    a[c - 'a'] ++;
                }
                for(int i = 0; i < 26; i ++) {
                    arr[i] = Math.min(arr[i], a[i]);
                }
            }
            for(int i  = 0; i < 26; i ++) {
                while(arr[i] > 0) {
                    ans.add(String.valueOf((char)(i + 'a')));
                    arr[i] --;
                }
            }

            return ans;
        }
    }
}
