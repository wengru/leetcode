public class LeetCode31 {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int k = -1;
        for (int i = nums.length-2; i >= 0; --i) {
            if (nums[i] < nums[i+1]) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            swap(nums, k+1, nums.length-1);
        } else {
            for (int i=nums.length-1; i > k; --i) {
                if (nums[i] > nums[k]) {
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k] = temp;
                    break;
                }
            }
            swap(nums, k+1, nums.length-1);
        }
//        StringBuilder sb = new StringBuilder();
//        sb.append(\"[\");
//        for (int n : nums) {
//            sb.append(n + \";\");
//        }
//        sb.append(\"]\");
//        System.out.println(sb.toString());
    }

    public void swap(int[] nums, int startIdx, int endIdx) {
        while (startIdx < endIdx) {
            int temp = nums[startIdx];
            nums[startIdx] = nums[endIdx];
            nums[endIdx] = temp;
            startIdx++;
            endIdx--;
        }
    }

    public static void main(String[] args) {
        LeetCode31 l = new LeetCode31();
        l.nextPermutation(new int[]{1,3,5,4,1}); // [1,4,1,3,5]
        l.nextPermutation(new int[]{1,2,3}); // [1,3,2]
        l.nextPermutation(new int[]{3,2,1}); // [1,2,3]
        l.nextPermutation(new int[]{1,1,5}); // [1,5,1]
        l.nextPermutation(new int[]{1}); // [1]
        l.nextPermutation(new int[]{1,1}); // [1,1]
    }
}
