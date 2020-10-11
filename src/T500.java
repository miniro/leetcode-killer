import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class T500 {
    static class Solution {
        public static void findWords(String[] words) {
            char[] line1 = "QWERTYUIOP".toCharArray();
            char[] line2 = "ASDFGHJKL".toCharArray();
            char[] line3 = "ZXCVBNM".toCharArray();
            int[] arr = new int[26];
            for(char c : line1) {
                arr[c - 'A'] = 1;
            }
            for(char c : line2) {
                arr[c - 'A'] = 2;
            }
            for(char c : line3) {
                arr[c - 'A'] = 3;
            }
            List<String> result = Arrays.stream(words)
                    .map(word -> word.toUpperCase())
                    .collect(Collectors.toList());
            System.out.println(result);
        }

        public static void main(String[] args) {
            String[] words = new String[]{"Hello", "Dad"};
            findWords(words);
        }
    }
}
