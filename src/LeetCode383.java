public class LeetCode383 {

    // 哈希+计数器，用数组代替哈希，根据具体字符索引到对应下标
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char c : magazine.toCharArray()){
            count[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode383 l = new LeetCode383();
        System.out.println(l.canConstruct("a", "b")); // false
        System.out.println(l.canConstruct("aa", "ab")); // false
        System.out.println(l.canConstruct("aa", "aab")); // true
    }

}
