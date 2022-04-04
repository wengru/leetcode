import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode42 {

    // dynamic, time O(3n) = O(n), space O(2n) = O(n)
//    public int trap(int[] height) {
//        if (height == null || height.length == 0) {
//            return 0;
//        }
//        int[][] maxHeight = new int[2][height.length];
//        int tempMaxHeight = height[0], total = 0;
//        for (int i=1; i<height.length; ++i) {
//            tempMaxHeight = maxHeight[0][i] = Math.max(tempMaxHeight, height[i-1]);
//        }
//        tempMaxHeight = height[height.length-1];
//        for (int i=height.length-2; i>=0; --i) {
//            tempMaxHeight = maxHeight[1][i] = Math.max(tempMaxHeight, height[i+1]);
//        }
//        for (int i=1; i<height.length-1; ++i) {
//            int curr = Math.min(maxHeight[0][i], maxHeight[1][i]) - height[i];
//            total += curr > 0 ? curr : 0;
//        }
//        return total;
//    }

    // two pointer, time O(n), space O(1)
//    public int trap(int[] height) {
//        if (height == null || height.length == 0) {
//            return 0;
//        }
//        int left = 0, right = height.length-1, total = 0, leftMax = height[left], rightMax = height[right];
//        while (left < right) {
//            if (leftMax < rightMax) {
//                total += leftMax - height[left] > 0 ? leftMax - height[left] : 0;
//                leftMax = Math.max(leftMax, height[++left]);
//            } else {
//                total += rightMax - height[right] > 0 ? rightMax - height[right] : 0;
//                rightMax = Math.max(rightMax, height[--right]);
//            }
//        }
//        return total;
//    }

    // stack
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0, temp = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0; i<height.length; ++i) {
            while (!deque.isEmpty() && height[deque.peek()] < height[i]) {
                temp = deque.pop();
                while (!deque.isEmpty() && height[deque.peek()] == height[temp]) {
                    temp = deque.pop();
                }
                if (!deque.isEmpty()) {
                    res += (Math.min(height[deque.peek()], height[i]) - height[temp]) * (i - deque.peek() - 1);
                }
            }
            deque.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode42 l = new LeetCode42();
        System.out.println(l.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})); // 6
        System.out.println(l.trap(new int[]{4,2,0,3,2,5})); // 9
        System.out.println(l.trap(new int[]{4,1,2,4})); // 5
    }

}
