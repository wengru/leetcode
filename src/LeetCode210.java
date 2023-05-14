import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class LeetCode210 {

    // BFS
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        int[] res = new int[numCourses];
//        if (numCourses == 0 || prerequisites == null) {
//            return res;
//        }
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
//            res[count++] = node;
//            for (int adjNode : adjacent[node]) {
//                inDegree[adjNode]--;
//                if (inDegree[adjNode] == 0) {
//                    queue.add(adjNode);
//                }
//            }
//        }
//        return count == numCourses ? res : new int[0];
//    }

    private Integer count = 0;

    // DFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if (numCourses == 0 || prerequisites == null) {
            return res;
        }
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
            if (dfs(marked, adjacent, i, res)) {
                return new int[0];
            }
        }
        // 每一轮结束以后还原
        count = 0;
        return res;
    }

    public boolean dfs(int[] marked, Set<Integer>[] adjacent, int node, int[] res) {
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
            if (dfs(marked, adjacent, preNode, res)) {
                return true;
            }
        }
        marked[node] = 2;
        res[count++] = node;
        return false;
    }

    public static void main(String[] args) {
        LeetCode210 l = new LeetCode210();
        TestUtil.printArray(l.findOrder(
                2,
                new int[][]{
                        new int[]{1,0}
                }
        )); // [0,1]
        TestUtil.printArray(l.findOrder(
                4,
                new int[][]{
                        new int[]{1,0},
                        new int[]{2,0},
                        new int[]{3,1},
                        new int[]{3,2}
                }
        )); // [0,2,1,3]
        TestUtil.printArray(l.findOrder(
                2,
                new int[][]{}
        )); // [1,0]
    }

}
