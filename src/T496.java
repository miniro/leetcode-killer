public class T496 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] result = new int[nums1.length];
            for(int i=0;i<nums1.length;i++) {
                int selected = -1;
                int index = 0;
                while(index < nums2.length) {
                    if(nums1[i] == nums2[index]) {
                        break;
                    }
                    index ++;
                }
                index ++;
                while(index < nums2.length) {
                    if(nums1[i] < nums2[index]) {
                        selected = nums2[index];
                        break;
                    }
                    index ++;
                }
                result[i] = selected;
            }
            return result;
        }
    }
}
