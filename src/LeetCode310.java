import java.util.*;

public class LeetCode310 {

    // 对每个节点做dfs，最简单的解法（超时）
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        List<Integer> res = new ArrayList<>();
//        int[] record = new  int[n];
//        int min = Integer.MAX_VALUE;
//        for (int i=0; i<n; i++) {
//            // 深度遍历单个结点并记录
//            record[i] = dfs(i, edges, new int[n]);
//            min = Math.min(min, record[i]);
//        }
//        for (int i=0; i<record.length; i++) {
//            if (record[i] == min) {
//                res.add(i);
//            }
//        }
//        return res;
//    }
//
//    public int dfs(int n, int[][] edges, int[] nodes) {
//        nodes[n] = 1;
//        int height = 0;
//        for (int[] edge : edges) {
//            if ((edge[0] == n || edge[1] == n) && (nodes[edge[0] == n ? edge[1] : edge[0]] != 1)) {
//                height = Math.max(height, dfs(edge[0] == n ? edge[1] : edge[0], edges, nodes));
//            }
//        }
//        nodes[n] = 0;
//        return height == 0 ? 1 : height + 1;
//    }

    // dfs or bfs
    // 在数据量大的情况下需要把边处理为另外一种结构，避免重复遍历
    // 因为从初始结点开始找最远的结点和找到最长的链路都只需要遍历一遍所有边，所以时间复杂度O(2n) = O(n)，n是题目给出的边的数量
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        List<Integer>[] adj = new List[n];
//        for (int i=0; i<n; i++) {
//            adj[i] = new ArrayList<>();
//        }
//        for (int[] edge : edges) {
//            adj[edge[0]].add(edge[1]);
//            adj[edge[1]].add(edge[0]);
//        }
//        List<Integer> res = new ArrayList<>();
//        int[] record = new int[n];
//        int[] depths = new int[n];
//        // 以第一个结点开始，先找到距离它最远的一个结点，其中depths记录的是从第一个结点开始的结点对应下标的深度
//        findFarthest(0, 0, adj, record, depths);
//        int maxLength = 1;
//        for (int i : depths) {
//            maxLength = Math.max(maxLength, i);
//        }
//        // 从最远的结点开始，找离它最远的结点，并把链路的中间结点加入到答案里
//        for (int i=0; i<depths.length; i++) {
//            if (maxLength == depths[i]) {
//                List<Integer> path = findFarthestPath(i, adj, new int[n]);
//                res.add(path.get(path.size()/2));
//                if (path.size() > 0 && (path.size()&1) == 0) {
//                    res.add(path.get((path.size() - 1)/2));
//                }
//                // 因为最长路径即有多条相同的中点也只有1个，所以找到可以直接break
//                break;
//            }
//        }
//        return res;
//    }
//
//    public void findFarthest(int n, int depth, List<Integer>[] adj, int[] record, int[] depths) {
//        depths[n] = depth + 1;
//        record[n] = 1;
//        for (int i : adj[n]) {
//            if (record[i] == 0) {
//                findFarthest(i, depth + 1, adj, record, depths);
//            }
//        }
//    }
//
//    public List<Integer> findFarthestPath(int n, List<Integer>[] adj, int[] record) {
//        List<Integer> path = new ArrayList<>();
//        record[n] = 1;
//        for (int i : adj[n]) {
//            if (record[i] == 0) {
//                List<Integer> temp = findFarthestPath(i, adj, record);
//                if (temp.size() > path.size()) {
//                    path = temp;
//                }
//            }
//        }
//        path.add(n);
//        return path;
//    }

    // 拓扑排序
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        List<Integer> result = new ArrayList<>();
//        if (n == 1) {
//            result.add(0);
//            return result;
//        }
//        Queue<Integer> queue = new ArrayDeque<>();
//        List<Integer>[] adj = new List[n];
//        for (int i=0; i<adj.length; i++) {
//            adj[i] = new ArrayList<>();
//        }
//        int[] degree = new int[n]; // 度
//        for (int[] edge : edges) {
//            degree[edge[0]]++;
//            degree[edge[1]]++;
//            adj[edge[0]].add(edge[1]);
//            adj[edge[1]].add(edge[0]);
//        }
//        for (int i=0; i<degree.length; i++) {
//            if (degree[i] == 1) {
//                queue.offer(i);
//            }
//        }
//        int remind = n;
//        while (remind > 2) {
//            int sz = queue.size();
//            remind -= sz;
//            for (int i=0; i < sz; i++) {
//                int node = queue.poll();
//                for (int adjNode : adj[node]) {
//                    degree[adjNode]--;
//                    if (degree[adjNode] == 1) {
//                        queue.offer(adjNode);
//
//                    }
//                }
//            }
//        }
//        while (!queue.isEmpty()) {
//            result.add(queue.poll());
//        }
//        return result;
//    }

    // 动态规划 树形dp
    int N = 20010, M = N * 2, idx = 0;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    int[] f1 = new int[N], f2 = new int[N], g = new int[N], p = new int[N];

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Arrays.fill(he, -1);
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            add(a, b); add(b, a);
        }
        dfs1(0, -1);
        dfs2(0, -1);
        List<Integer> ans = new ArrayList<>();
        int min = n;
        for (int i = 0; i < n; i++) {
            int cur = Math.max(f1[i], g[i]);
            if (cur < min) {
                min = cur;
                ans.clear();
                ans.add(i);
            } else if (cur == min) {
                ans.add(i);
            }
        }
        return ans;
    }

    int dfs1(int u, int fa) {
        for (int i = he[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == fa) continue;
            int sub = dfs1(j, u) + 1;
            if (sub > f1[u]) {
                f2[u] = f1[u];
                f1[u] = sub;
                p[u] = j;
            } else if (sub > f2[u]) {
                f2[u] = sub;
            }
        }
        return f1[u];
    }

    void dfs2(int u, int fa) {
        for (int i = he[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == fa) continue;
            if (p[u] != j) g[j] = Math.max(g[j], f1[u] + 1);
            else g[j] = Math.max(g[j], f2[u] + 1);
            g[j] = Math.max(g[j], g[u] + 1);
            dfs2(j, u);
        }
    }

    public static void main(String[] args) {
        LeetCode310 l = new LeetCode310();
        System.out.println(l.findMinHeightTrees(
                1,
                new int[][]{}
        )); // [0]
        System.out.println(l.findMinHeightTrees(
                2,
                new int[][]{
                        new int[]{0,1}
                }
        )); // [0,1]
        System.out.println(l.findMinHeightTrees(
                4,
                new int[][]{
                        new int[]{1,0},
                        new int[]{1,2},
                        new int[]{1,3}
                }
        )); // [1]
        System.out.println(l.findMinHeightTrees(
                6,
                new int[][]{
                        new int[]{3,0},
                        new int[]{3,1},
                        new int[]{3,2},
                        new int[]{3,4},
                        new int[]{5,4}
                }
        )); // [3,4]
        System.out.println(l.findMinHeightTrees(
                6,
                new int[][]{
                        new int[]{0,1},
                        new int[]{0,2},
                        new int[]{0,3},
                        new int[]{3,4},
                        new int[]{4,5}
                }
        )); // [3]
    }

}
