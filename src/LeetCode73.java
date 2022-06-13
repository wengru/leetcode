public class LeetCode73 {

    public void setZeroes(int[][] matrix) {
        return;
    }

    public static void main(String[] args) {
        LeetCode73 l = new LeetCode73();
        l.setZeroes(new int[][]{
                new int[]{1,1,1},
                new int[]{1,0,1},
                new int[]{1,1,1}
        }); // [[1,0,1],[0,0,0],[1,0,1]]
        l.setZeroes(new int[][]{
                new int[]{0,1,2,0},
                new int[]{3,4,5,2},
                new int[]{1,3,1,5}
        }); // [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
    }

}
