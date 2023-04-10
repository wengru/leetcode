import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode139 {

    // dfs + backtracking + memory
//    public boolean wordBreak(String s, List<String> wordDict) {
//        if (s == null || s.equals("") || wordDict == null || wordDict.size() == 0) {
//            return false;
//        }
//        Map<String, Boolean> wordMap = new HashMap<>();
//        for (String word : wordDict) {
//            wordMap.put(word, true);
//        }
//        int[] arr = new int[s.length()];
//        boolean res = dfs(s, wordMap, arr, 0);
//        return res;
//    }
//
//    /**
//     *
//     * @param s 待处理字符串
//     * @param wordMap 可用单词字典map
//     * @param arr 记忆数组
//     * @param idx 当前子字符串的起始位置
//     * @return
//     */
//    public boolean dfs(String s, Map<String, Boolean> wordMap, int[] arr, int idx) {
//        if (s == null || s.equals("")) {
//            return true;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            // 左半部分已经匹配
//            if (wordMap.containsKey(s.substring(0, i + 1))) {
//                if (i + 1 == s.length()) {
//                    arr[idx] = 1;
//                    return true;
//                } else if (arr[idx + i + 1] == -1) {
//                    continue;
//                } else if (arr[idx + i + 1] == 1) {
//                    return true;
//                } else {
//                    boolean res = dfs(s.substring(i + 1), wordMap, arr, idx + i + 1);
//                    arr[idx + i + 1] = res ? 1 : -1;
//                    if (res) {
//                        return res;
//                    }
//                }
//            }
//        }
//        arr[idx] = -1;
//        return false;
//    }

    // dp 时间O(m*n) m:s的长度, n:单词最大长度
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.equals("") || wordDict == null || wordDict.size() == 0) {
            return false;
        }
        Map<String, Boolean> wordMap = new HashMap<>();
        wordMap.put("", true);
        int maxWordLen = 1;
        for (String word : wordDict) {
            maxWordLen = maxWordLen < word.length() ? word.length() : maxWordLen;
            wordMap.put(word, true);
        }
        // 1表示可以由字典里的单词组成，0表示不能
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= maxWordLen && i - j >= 0; j++) {
                if (wordMap.containsKey(s.substring(i - j, i + 1)) && dp[i - j] == 1) {
                    dp[i + 1] = 1;
                    break;
                }
            }
        }
        return dp[s.length()] == 1 ? true : false;
    }

    public static void main(String[] args) {
        LeetCode139 l = new LeetCode139();
        System.out.println(l.wordBreak("leetcode", Arrays.asList("leet","code"))); // true
        System.out.println(l.wordBreak("applepenapple", Arrays.asList("apple","pen"))); // true
        System.out.println(l.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat"))); // false
        System.out.println(l.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))); // false
        System.out.println(l.wordBreak("aaaaaaa", Arrays.asList("aaaa","aaa"))); // true
        System.out.println(l.wordBreak("catsandogcat", Arrays.asList("cats","dog","sand","and","cat","an"))); // true
        System.out.println(l.wordBreak(
                "fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami",
                Arrays.asList("kfomka","hecagbngambii","anobmnikj","c","nnkmfelneemfgcl","ah","bgomgohl","lcbjbg","ebjfoiddndih","hjknoamjbfhckb","eioldlijmmla","nbekmcnakif","fgahmihodolmhbi","gnjfe","hk","b","jbfgm","ecojceoaejkkoed","cemodhmbcmgl","j","gdcnjj","kolaijoicbc","liibjjcini","lmbenj","eklingemgdjncaa","m","hkh","fblb","fk","nnfkfanaga","eldjml","iejn","gbmjfdooeeko","jafogijka","ngnfggojmhclkjd","bfagnfclg","imkeobcdidiifbm","ogeo","gicjog","cjnibenelm","ogoloc","edciifkaff","kbeeg","nebn","jdd","aeojhclmdn","dilbhl","dkk","bgmck","ohgkefkadonafg","labem","fheoglj","gkcanacfjfhogjc","eglkcddd","lelelihakeh","hhjijfiodfi","enehbibnhfjd","gkm","ggj","ag","hhhjogk","lllicdhihn","goakjjnk","lhbn","fhheedadamlnedh","bin","cl","ggjljjjf","fdcdaobhlhgj","nijlf","i","gaemagobjfc","dg","g","jhlelodgeekj","hcimohlni","fdoiohikhacgb","k","doiaigclm","bdfaoncbhfkdbjd","f","jaikbciac","cjgadmfoodmba","molokllh","gfkngeebnggo","lahd","n","ehfngoc","lejfcee","kofhmoh","cgda","de","kljnicikjeh","edomdbibhif","jehdkgmmofihdi","hifcjkloebel","gcghgbemjege","kobhhefbbb","aaikgaolhllhlm","akg","kmmikgkhnn","dnamfhaf","mjhj","ifadcgmgjaa","acnjehgkflgkd","bjj","maihjn","ojakklhl","ign","jhd","kndkhbebgh","amljjfeahcdlfdg","fnboolobch","gcclgcoaojc","kfokbbkllmcd","fec","dljma","noa","cfjie","fohhemkka","bfaldajf","nbk","kmbnjoalnhki","ccieabbnlhbjmj","nmacelialookal","hdlefnbmgklo","bfbblofk","doohocnadd","klmed","e","hkkcmbljlojkghm","jjiadlgf","ogadjhambjikce","bglghjndlk","gackokkbhj","oofohdogb","leiolllnjj","edekdnibja","gjhglilocif","ccfnfjalchc","gl","ihee","cfgccdmecem","mdmcdgjelhgk","laboglchdhbk","ajmiim","cebhalkngloae","hgohednmkahdi","ddiecjnkmgbbei","ajaengmcdlbk","kgg","ndchkjdn","heklaamafiomea","ehg","imelcifnhkae","hcgadilb","elndjcodnhcc","nkjd","gjnfkogkjeobo","eolega","lm","jddfkfbbbhia","cddmfeckheeo","bfnmaalmjdb","fbcg","ko","mojfj","kk","bbljjnnikdhg","l","calbc","mkekn","ejlhdk","hkebdiebecf","emhelbbda","mlba","ckjmih","odfacclfl","lgfjjbgookmnoe","begnkogf","gakojeblk","bfflcmdko","cfdclljcg","ho","fo","acmi","oemknmffgcio","mlkhk","kfhkndmdojhidg","ckfcibmnikn","dgoecamdliaeeoa","ocealkbbec","kbmmihb","ncikad","hi","nccjbnldneijc","hgiccigeehmdl","dlfmjhmioa","kmff","gfhkd","okiamg","ekdbamm","fc","neg","cfmo","ccgahikbbl","khhoc","elbg","cbghbacjbfm","jkagbmfgemjfg","ijceidhhajmja","imibemhdg","ja","idkfd","ndogdkjjkf","fhic","ooajkki","fdnjhh","ba","jdlnidngkfffbmi","jddjfnnjoidcnm","kghljjikbacd","idllbbn","d","mgkajbnjedeiee","fbllleanknmoomb","lom","kofjmmjm","mcdlbglonin","gcnboanh","fggii","fdkbmic","bbiln","cdjcjhonjgiagkb","kooenbeoongcle","cecnlfbaanckdkj","fejlmog","fanekdneoaammb","maojbcegdamn","bcmanmjdeabdo","amloj","adgoej","jh","fhf","cogdljlgek","o","joeiajlioggj","oncal","lbgg","elainnbffk","hbdi","femcanllndoh","ke","hmib","nagfahhljh","ibifdlfeechcbal","knec","oegfcghlgalcnno","abiefmjldmln","mlfglgni","jkofhjeb","ifjbneblfldjel","nahhcimkjhjgb","cdgkbn","nnklfbeecgedie","gmllmjbodhgllc","hogollongjo","fmoinacebll","fkngbganmh","jgdblmhlmfij","fkkdjknahamcfb","aieakdokibj","hddlcdiailhd","iajhmg","jenocgo","embdib","dghbmljjogka","bahcggjgmlf","fb","jldkcfom","mfi","kdkke","odhbl","jin","kcjmkggcmnami","kofig","bid","ohnohi","fcbojdgoaoa","dj","ifkbmbod","dhdedohlghk","nmkeakohicfdjf","ahbifnnoaldgbj","egldeibiinoac","iehfhjjjmil","bmeimi","ombngooicknel","lfdkngobmik","ifjcjkfnmgjcnmi","fmf","aoeaa","an","ffgddcjblehhggo","hijfdcchdilcl","hacbaamkhblnkk","najefebghcbkjfl","hcnnlogjfmmjcma","njgcogemlnohl","ihejh","ej","ofn","ggcklj","omah","hg","obk","giig","cklna","lihaiollfnem","ionlnlhjckf","cfdlijnmgjoebl","dloehimen","acggkacahfhkdne","iecd","gn","odgbnalk","ahfhcd","dghlag","bchfe","dldblmnbifnmlo","cffhbijal","dbddifnojfibha","mhh","cjjol","fed","bhcnf","ciiibbedklnnk","ikniooicmm","ejf","ammeennkcdgbjco","jmhmd","cek","bjbhcmda","kfjmhbf","chjmmnea","ifccifn","naedmco","iohchafbega","kjejfhbco","anlhhhhg"))
        ); // true
    }

}
