package other;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public int[][] a1 = new int[1024][1024];
    public int[][] a2 = new int[1024][1024];
    public int[][] a3 = new int[1024][1024];
    public int[][] a4 = new int[1024][1024];

    public class TestClass {

        int[][] a = new int[1][1];

        public int[][] getA() {
            return a;
        }

        public void setA(int[][] a) {
            this.a = a;
        }

    }

    public static void main(String[] args) {
        TestMain t = new TestMain();
        List list = new ArrayList();
        for (int i=0; i<4; i++) {
            TestClass testClass = new TestMain().new TestClass();
            list.add(testClass);
        }
        System.out.println("结束...");
    }

}
