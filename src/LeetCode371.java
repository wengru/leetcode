public class LeetCode371 {

    public int getSum(int a, int b) {
        int carry = (a&b)<<1, sum = a^b, add;
        while (carry != 0) {
            add = sum^carry;
            carry = (sum&carry)<<1;
            sum = add;
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode371 l = new LeetCode371();
        System.out.println(l.getSum(1,2)); // 3
        System.out.println(l.getSum(2,3)); // 5
    }

}
