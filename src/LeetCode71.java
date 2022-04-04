import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode71 {

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }
        Deque<String> deque = new ArrayDeque<>();
        for (String pathName : path.split("/")) {
            if (pathName.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pop();
                }
            } else if (!pathName.equals("") && !pathName.equals(".")) {
                deque.push(pathName);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.append("/").append(deque.pollLast());
        }
        return res.toString().equals("") ? "/" : res.toString();
    }

    public static void main(String[] args) {
        LeetCode71 l = new LeetCode71();
        System.out.println(l.simplifyPath("/home/")); // "/home"
        System.out.println(l.simplifyPath("/../")); // "/"
        System.out.println(l.simplifyPath("/home//foo/")); // "/home/foo"
        System.out.println(l.simplifyPath("/a/./b/../../c/")); // "/c"
        System.out.println(l.simplifyPath("/a/../../b/../c//.//")); // "/c"
    }

}
