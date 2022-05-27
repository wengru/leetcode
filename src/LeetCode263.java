public class LeetCode263 {

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        LeetCode263 l = new LeetCode263();
        System.out.println(l.isUgly(6)); // true
        System.out.println(l.isUgly(1)); // true
        System.out.println(l.isUgly(14)); // false
    }

}
