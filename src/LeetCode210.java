public class LeetCode210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return new int[0];
    }

    public static void main(String[] args) {
        LeetCode210 l = new LeetCode210();
        l.findOrder(
                2,
                new int[][]{
                        new int[]{1,0}
                }
        );
        l.findOrder(
                2,
                new int[][]{
                        new int[]{1,0},
                        new int[]{0,1}
                }
        );
    }

}
