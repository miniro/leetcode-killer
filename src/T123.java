public class T123 {
    public static int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int pro1 = 0;
        int pro2 = 0;
        for(int price : prices) {
            buy1 = Math.min(buy1, price);
            pro1 = Math.max(pro1, price - buy1);
            buy2 = Math.min(buy2, price - pro1);
            pro2 = Math.max(pro2, price - buy2);
        }
        return pro2;
    }

    public static void main(String[] args) {
        maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
    }
}
