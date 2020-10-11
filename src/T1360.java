public class T1360 {
    class Solution {
        int[][] tmpMonth = {
                {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
        };

        public int daysBetweenDates(String date1, String date2) {
            if(date1.compareTo(date2) > 0) {
                return daysBetweenDates(date2, date1);
            }
            int result = 0;
            int year1 = Integer.parseInt(date1.split("-")[0]);
            int year2 = Integer.parseInt(date2.split("-")[0]);
            result = getDays(date2) - getDays(date1);
            while(year1 < year2) {
                result += isLeapYear(year1) ? 366 : 365;
                year1 ++;
            }
            return result;
        }

        public boolean isLeapYear(int year) {
            if(year % 400 == 0 || year % 100 != 0 && year % 4 == 0) {
                return true;
            }
            return false;
        }

        public int getDays(String data1) {
            int year = Integer.parseInt(data1.split("-")[0]);
            int month = Integer.parseInt(data1.split("-")[1]);
            int day = Integer.parseInt(data1.split("-")[2]);
            int[] calendar = isLeapYear(year) ? tmpMonth[1] : tmpMonth[0];
            int result = 0;
            for(int i = 0; i < month; i ++) {
                result += calendar[i];
            }
            return result + day;
        }
    }
}
