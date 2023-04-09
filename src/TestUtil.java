public class TestUtil {

    public static void printArray(int[][] nums) {
        if (nums == null || nums.length == 0) {
            System.out.println("[]");
        }
        StringBuilder stringBuilder = new StringBuilder("[\n");
        for (int i = 0; i < nums.length; i++) {
            stringBuilder.append("[");
            for (int j = 0; j < nums[i].length; j++) {
                stringBuilder.append(nums[i][j]);
                if (j != nums[i].length - 1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("]");
            if (i != nums.length - 1) {
                stringBuilder.append(",\n");
            }
        }
        stringBuilder.append("\n]");
        System.out.println(stringBuilder.toString());
    }

    public static void printArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            System.out.print("[]");
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < nums.length; i++) {
            stringBuilder.append(i);
            if (i != nums.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }

}
