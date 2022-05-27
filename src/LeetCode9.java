public class LeetCode9 {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int n = x, y = 0;
        while (n > 0) {
            int z = y;
            z *= 10;
            z += n%10;
            n /= 10;
            // if number overflow
            if (z/10 != y) {
                return false;
            }
            y = z;
        }
        return y == x;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode9().isPalindrome(12321));
    }
}

