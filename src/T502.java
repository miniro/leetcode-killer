
import java.util.PriorityQueue;

public class T502 {
    class Solution {
        public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
            PriorityQueue<Integer> CapitalQueue = new PriorityQueue<>((x, y) -> Capital[x] - Capital[y]);
            PriorityQueue<Integer> ProfitsQueue = new PriorityQueue<>((x, y) -> Profits[y] - Profits[x]);
            for(int i = 0; i < Capital.length; i ++) {
                CapitalQueue.add(i);
            }
            while(k > 0) {
                while(!CapitalQueue.isEmpty() && Capital[CapitalQueue.peek()] <= W) {
                    int index = CapitalQueue.poll();
                    ProfitsQueue.add(index);
                }
                if(ProfitsQueue.isEmpty()) {
                    break;
                }
                while(!ProfitsQueue.isEmpty()) {
                    int index = ProfitsQueue.poll();
                    W += Profits[index];
                    k--;
                    if(k == 0) {
                        break;
                    }
                }
            }
            return W;
        }
    }
}
