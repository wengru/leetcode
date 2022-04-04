public class LeetCode69 {

//    public int mySqrt(int x) {
//        if (x < 2) {
//            return x == 1 ? 1 : 0;
//        }
//        int divide = 1;
//        while (x / divide > divide) {
//            divide++;
//        }
//        return (x / divide) == divide ? divide : divide - 1;
//    }

    public int mySqrt(int x) {
        if (x < 2) {
            return x == 1 ? 1 : 0;
        }
        int l = 0, r = x, res = 0;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            // 用除法，防止乘法int溢出
            if (x / mid < mid) {
                r = mid - 1;
            } else {
                res = l = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode69 l = new LeetCode69();
        System.out.println(l.mySqrt(2)); // 1
        System.out.println(l.mySqrt(4)); // 2
        System.out.println(l.mySqrt(8)); // 2
        System.out.println(l.mySqrt(2147483647)); // 46340
    }

}
