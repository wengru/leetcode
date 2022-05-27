class Trie {

    // 另一种解法，二维数组

    class TrieNode {
        boolean end = false;
        TrieNode[] nodes = new TrieNode[26];
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.nodes[idx] == null) {
                node.nodes[idx] = new TrieNode();
            }
            node = node.nodes[idx];
        }
        node.end = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.nodes[idx] == null) {
                return false;
            }
            node = node.nodes[idx];
        }
        return node.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (node.nodes[idx] == null) {
                return false;
            }
            node = node.nodes[idx];
        }
        return true;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */