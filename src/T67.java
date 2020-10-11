public class T67 {
    class Solution {
        public String addBinary(String a, String b) {
            long value1 = Long.parseLong(a, 2);
            long value2 = Long.parseLong(b, 2);
            return Long.toString((long)value1 + value2, 2);
        }
    }
}
