class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}

class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode root) {
        if (index == word.length()) return root.isEnd;
        char ch = word.charAt(index);
        if (ch != '.') {
            int childIndex = ch - 'a';
            TrieNode child = root.children[childIndex];
            if (child != null && dfs(word, index+1, child)) {
                return true;
            }
        } else {
            for (TrieNode child : root.children) {
                if (child != null && dfs(word, index+1, child)) {
                    return true;
                }
            }
        }
        

        return false;
    }
}
