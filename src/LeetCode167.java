public class LeetCode167 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{};
        }
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{left+1, right+1};
    }

    public static void main(String[] args) {
        LeetCode167 l = new LeetCode167();
//        System.out.println();
    }

}
