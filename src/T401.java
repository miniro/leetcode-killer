import java.util.ArrayList;
import java.util.List;
public class T401 {
    class Solution {
        List<Integer> hours = new ArrayList<>();
        List<Integer> minutes = new ArrayList<>();
        public List<String> readBinaryWatch(int num) {
            List<String> result = new ArrayList<>();
            for(int i = 0; i <= num; i++) {
                hours.clear();
                minutes.clear();
                if(i >= 0 && i < 4) {
                    getTime(4, i, 0, 0, hours);
                }
                if(num - i >= 0 && num - i < 6) {
                    getTime(6, num - i, 0, 0, minutes);
                }
                for(int hour : hours) {
                    for(int minute : minutes) {
                        if(hour < 12 && minute < 60) {
                            String string = String.valueOf(hour) + ":" + String.format("%02d", minute);
                            result.add(string);
                        }
                    }
                }
            }

            return result;
        }

        public void getTime(int len, int x, int result, int index, List<Integer> hours) {
            if(index > len) {
                return;
            }
            if(x == 0) {
                hours.add(result);
                return;
            }
            getTime(len, x - 1, result + (1 << index), index + 1, hours);
            getTime(len, x, result, index + 1, hours);
        }
    }
}
