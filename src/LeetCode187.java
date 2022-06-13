import java.util.ArrayList;
import java.util.List;

public class LeetCode187 {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        return res;
    }

    public static void main(String[] args) {
        LeetCode187 l = new LeetCode187();
        System.out.println(l.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")); //["AAAAACCCCC","CCCCCAAAAA"]
        System.out.println(l.findRepeatedDnaSequences("AAAAAAAAAAAAA")); // ["AAAAAAAAAA"]
    }

}
