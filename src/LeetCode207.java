public class LeetCode207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return false;
    }

    public static void main(String[] args) {
        LeetCode207 l = new LeetCode207();
        l.canFinish(
                2,
                new int[][]{
                        new int[]{1,0}
                }
        ); // [0,1]
        l.canFinish(
                2,
                new int[][]{
                        new int[]{1,0},
                        new int[]{2,0},
                        new int[]{3,1},
                        new int[]{3,2}
                }
        ); // [0,2,1,3]
        l.canFinish(
                1,
                new int[][]{}
        ); // [0]
    }

}
