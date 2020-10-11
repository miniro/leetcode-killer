public class T307 {
    class NumArray {
        int n;
        int[] tree;

        public NumArray(int[] nums) {
            if(nums.length > 0) {
                n = nums.length;
                tree = new int[n * 2];
                for(int i = 0; i < n; i++) {
                    tree[i + n] = nums[i];
                }
                for(int i = n - 1; i > 0; i--) {
                    tree[i] = tree[i * 2] + tree[i * 2 + 1];
                }
            }
        }

        public void update(int i, int val) {
            int index = i + n;
            tree[index] = val;
            while(index > 0) {
                int left = index;
                int right = index;
                if(index % 2 == 1) {
                    left = index - 1;
                } else {
                    right = index + 1;
                }
                tree[index / 2] = tree[left] + tree[right];
                index /= 2;
            }
        }

        public int sumRange(int i, int j) {
            i += n;
            j += n;
            int sum = 0;
            while(i <= j) {
                if(i % 2 == 1) {
                    sum += tree[i];
                    i++;
                }
                if(j % 2 == 0) {
                    sum += tree[j];
                    j--;
                }
                i /= 2;
                j /= 2;
            }
            return sum;
        }
    }
}
