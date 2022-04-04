import java.util.*;

public class LeetCode49 {

    // sort
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> res = new ArrayList<>();
//        if (strs == null || strs.length == 0) {
//            return res;
//        }
//        Map<String, Integer> map = new HashMap<>();
//        for (String str : strs) {
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            if (!map.containsKey(new String(chars))) {
//                res.add(new ArrayList<String>());
//                res.get(res.size()-1).add(str);
//                map.put(new String(chars), res.size()-1);
//            } else {
//                res.get(map.get(new String(chars))).add(str);
//            }
//        }
//        return res;
//    }

    // count
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c-'a']++;
            }
            StringBuilder s = new StringBuilder();
            for (int i=0; i<count.length; ++i) {
                if (count[i] > 0) {
                    s.append((char)(i-'a')).append(count[i]);
                }
            }
            if (!map.containsKey(s.toString())) {
                res.add(new ArrayList<String>());
                res.get(res.size()-1).add(str);
                map.put(s.toString(), res.size()-1);
            } else {
                res.get(map.get(s.toString())).add(str);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode49 l = new LeetCode49();
        // [["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(l.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        // [[""]]
        System.out.println(l.groupAnagrams(new String[]{""}));
        // [["a"]]
        System.out.println(l.groupAnagrams(new String[]{"a"}));
    }

}
