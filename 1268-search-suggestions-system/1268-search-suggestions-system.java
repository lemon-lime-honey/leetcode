class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = this.root;
    
        for (int i = 0; i < word.length(); i++) {
            int target = word.charAt(i) - 'a';
            if (node.children[target] == null) {
                node.children[target] = new TrieNode();
            }
            node = node.children[target];
            if (node.words.size() < 3) {
                node.words.add(word);
            }
        }
    }

    public List<String> search(String word) {
        TrieNode node = this.root;

        for (int i = 0; i < word.length(); i++) {
            int target = word.charAt(i) - 'a';
            if (node.children[target] == null) {
                return new ArrayList<>();
            }
            node = node.children[target];
        }

        return node.words;
    }
}

class TrieNode {
    TrieNode[] children;
    List<String> words;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.words = new ArrayList<>();
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();

        for (String product: products) {
            trie.insert(product);
        }

        for (int i = 0; i < searchWord.length(); i++) {
            result.add(trie.search(searchWord.substring(0, i + 1)));
        }

        return result;
    }
}