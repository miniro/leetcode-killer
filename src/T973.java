import java.util.Comparator;
import java.util.PriorityQueue;

public class T973 {
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Solution {
        public int[][] kClosest(int[][] points, int K) {
            PriorityQueue<Point> queue = new PriorityQueue<>(new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    return Math.abs(o2.x * o2.x + o2.y * o2.y) - Math.abs(o1.x * o1.x + o1.y * o1.y);
                }
            });
            for(int[] point : points) {
                if(queue.isEmpty() || queue.size() < K) {
                    queue.offer(new Point(point[0], point[1]));
                } else if(queue.size() == K) {
                    Point p =queue.peek();
                    if(Math.abs(point[0] * point[0] + point[1] * point[1]) <
                            Math.abs(p.x * p.x + p.y * p.y)) {
                        queue.poll();
                        queue.offer(new Point(point[0], point[1]));
                    }
                }
            }
            int[][] result = new int[queue.size()][2];
            int index = 0;
            while(!queue.isEmpty()) {
                int[] element = new int[]{queue.peek().x, queue.peek().y};
                queue.poll();
                result[index ++] = element;
            }
            return result;
        }
    }
}
