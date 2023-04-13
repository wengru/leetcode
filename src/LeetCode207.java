import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class LeetCode207 {

    // BFS 时间复杂度O(M + N) 空间复杂度O(M + N) M: 结点数, N: 邻边数量
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        if (numCourses <= 0 || prerequisites == null) {
//            return false;
//        }
////        if (prerequisites.length == 0) {
////            return true;
////        }
//        int[] inDegree = new int[numCourses];
//        Set<Integer>[] adjacent = new Set[numCourses];
//        for (int i = 0; i < adjacent.length; i++) {
//            adjacent[i] = new HashSet<>();
//        }
//        for (int[] p : prerequisites) {
//            inDegree[p[0]]++;
//            adjacent[p[1]].add(p[0]);
//        }
//        Queue<Integer> queue = new ArrayDeque<>();
//        for (int i = 0; i < inDegree.length; i++) {
//            if (inDegree[i] == 0) {
//                queue.offer(i);
//            }
//        }
//        int count = 0;
//        while (!queue.isEmpty()) {
//            // 已经在队列里的结点入度都为0
//            int node = queue.poll();
//            count++;
//            for (int adjNode : adjacent[node]) {
//                inDegree[adjNode]--;
//                if (inDegree[adjNode] == 0) {
//                    queue.add(adjNode);
//                }
//            }
//        }
//        return count == numCourses;
//    }

    // DFS 思路是判断是否存在环，时间复杂度O(M + N) 空间复杂度O(M + N) M: 结点数, N: 邻边数量
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null) {
            return false;
        }
//        if (prerequisites.length == 0) {
//            return true;
//        }
        // 0 未遍历 1遍历中 2遍历完成
        int[] marked = new int[numCourses];
        Set<Integer>[] adjacent = new Set[numCourses];
        for (int i = 0; i < adjacent.length; i++) {
            adjacent[i] = new HashSet<>();
        }
        for (int[] p : prerequisites) {
            adjacent[p[0]].add(p[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (dfs(marked, adjacent, i)) {
                return false;
            }
        }
        return true;
    }

    // 判断是否存在环
    public boolean dfs(int[] marked, Set<Integer>[] adjacent, int node) {
        // 开始遍历，当前节点的mark置为1
        if (marked[node] == 2) {
            return false;
        }
        if (marked[node] == 1) {
            return true;
        }
        // 开始遍历，状态设置为遍历中
        marked[node] = 1;
        // 深度遍历依赖的结点
        for (Integer preNode : adjacent[node]) {
            if (dfs(marked, adjacent, preNode)) {
                return true;
            }
        }
        marked[node] = 2;
        return false;
    }

    public static void main(String[] args) {
        LeetCode207 l = new LeetCode207();
        System.out.println(l.canFinish(
                2,
                new int[][]{
                        new int[]{1,0}
                }
        )); // true
        System.out.println(l.canFinish(
                2,
                new int[][]{
                        new int[]{1,0},
                        new int[]{0,1}
                }
        )); // false
        System.out.println(l.canFinish(
                1,
                new int[][]{}
        )); // true
    }

}
