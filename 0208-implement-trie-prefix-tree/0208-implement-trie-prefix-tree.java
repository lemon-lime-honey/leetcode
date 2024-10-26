class TrieNode {
    Map<Character, TrieNode> children;
    boolean last;
    char value;

    public TrieNode() {
        children = new HashMap<>();
        last = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            if (node.children.containsKey(word.charAt(i))) {
                node = node.children.get(word.charAt(i));
            } else {
                TrieNode temp = new TrieNode();
                temp.value = word.charAt(i);
                node.children.put(word.charAt(i), temp);
                node = node.children.get(word.charAt(i));
            }
            if (i == word.length() - 1) {
                node.last = true;
            }
        }
    }
    
    public boolean search(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            if (node.children.containsKey(word.charAt(i))) {
                node = node.children.get(word.charAt(i));
            } else {
                return false;
            }
        }
        return node.last;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (int i = 0; i < prefix.length(); i++) {
            if (node.children.containsKey(prefix.charAt(i))) {
                node = node.children.get(prefix.charAt(i));
            } else {
                return false;
            }
        }

        return true;
    }
}
