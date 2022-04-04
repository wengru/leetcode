public class LeetCode58 {

//    public int lengthOfLastWord(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        String[] strs = s.split(" ");
//        return strs.length == 0 ? 0 : strs[strs.length-1].length();
//    }

    /**
     * filter the tail blank, then iterate form tail to head
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = 0;
        for (int i=s.length()-1; i>=0; --i) {
            if (s.charAt(i) == ' ') {
                if (length == 0) {
                    continue;
                } else {
                    return length;
                }
            } else {
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        LeetCode58 l = new LeetCode58();
        System.out.println(l.lengthOfLastWord("Hello World")); // 5
        System.out.println(l.lengthOfLastWord(" ")); // 0
    }

}
