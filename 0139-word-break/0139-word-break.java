class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();

        for (String word: wordDict) {
            trie.insert(word);
        }

        return trie.search(s);
    }
}

class TrieNode {
    char val;
    Map<Character, TrieNode> children;
    boolean last;

    public TrieNode() {
        this.last = false;
        this.children = new HashMap<>();
    }

    public TrieNode(char val) {
        this.val = val;
        this.last = false;
        this.children = new HashMap<>();
    }
}

class Trie {
    TrieNode root;
    Map<String, Boolean> found;

    public Trie() {
        this.root = new TrieNode();
        this.found = new HashMap<>();
    }

    public void insert(String word) {
        TrieNode node = this.root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.children.containsKey(word.charAt(i))) {
                TrieNode newNode = new TrieNode(word.charAt(i));
                node.children.put(word.charAt(i), newNode);
            }
            node = node.children.get(word.charAt(i));
        }
        node.last = true;
    }

    public boolean search(String str) {
        TrieNode node = this.root;

        for (int i = 0; i < str.length(); i++) {
            if (!node.children.containsKey(str.charAt(i))) {
                return false;
            }
            if (node.children.get(str.charAt(i)).last) {
                String left = str.substring(i + 1, str.length());
                if (!found.containsKey(left)) {
                    found.put(left, search(left));
                }
                if (found.get(left)) {
                    return true;
                }
            }
            node = node.children.get(str.charAt(i));
        }

        return node.last;
    }
}