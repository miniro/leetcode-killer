import java.util.ArrayList;
import java.util.List;

public class T75 {
    class Solution {
        public void sortColors(int[] nums) {
            int[] hashTable = new int[3];
            List<Integer> list = new ArrayList<>();
            int k = 0;
            for(int val : nums) {
                hashTable[val] ++;
            }
            for(int i=0;i<3;i++) {
                while(hashTable[i] > 0) {
                    list.add(i);
                    nums[k++] = i;
                    hashTable[i] --;
                }
            }
        }
    }
}
