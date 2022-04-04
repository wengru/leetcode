import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LeetCode84 {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] newHeights = Arrays.copyOf(heights, heights.length + 1);
        int res = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0; i<newHeights.length; ++i) {
            while (!deque.isEmpty() && newHeights[deque.peek()] > newHeights[i]) {
                int tempIdx = deque.pop();
                while (!deque.isEmpty() && newHeights[tempIdx] == newHeights[i]) {
                    tempIdx = deque.pop();
                }
                int tempArea = newHeights[tempIdx] * (deque.isEmpty() ? i : i - deque.peek() - 1);
                res = Math.max(tempArea, res);
            }
            deque.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode84 l = new LeetCode84();
        System.out.println(l.largestRectangleArea(new int[]{2,1,5,6,2,3})); // 10
        System.out.println(l.largestRectangleArea(new int[]{2,4})); // 4
        System.out.println(l.largestRectangleArea(new int[]{1})); // 1
        System.out.println(l.largestRectangleArea(new int[]{0,9})); // 9
        System.out.println(l.largestRectangleArea(new int[]{2,1,2})); // 3
        System.out.println(l.largestRectangleArea(new int[]{4,2,0,3,2,5})); // 6
    }

}
