public class LeetCode66 {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int carry = 1;
        for (int i=digits.length-1; i>=0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry == 1) {
            int[] digitsNew = new int[digits.length+1];
//            digitsNew[0] = 1;
//            System.arraycopy(digits, 0, digitsNew, 1, digits.length);
//            return digitsNew;
            // tricky
            digitsNew[0] = 1;
            return digitsNew;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        LeetCode66 l = new LeetCode66();
//        for (int n : l.plusOne(new int[]{1,2,3})) { // 1,2,4
//            System.out.print(n + ",");
//        }
//        System.out.println("");
//        for (int n : l.plusOne(new int[]{4,3,2,1})) { // 4,3,2,2
//            System.out.print(n + ",");
//        }
//        System.out.println("");
//        for (int n : l.plusOne(new int[]{0})) { // 1
//            System.out.print(n + ",");
//        }
//        System.out.println("");
        for (int n : l.plusOne(new int[]{9})) { // 1,0
            System.out.print(n + ",");
        }
        System.out.println("");
    }
}
