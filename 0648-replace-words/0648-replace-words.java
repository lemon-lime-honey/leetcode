class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean last;

    public TrieNode() {
        children = new HashMap<>();
    }
}

class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.children.containsKey(word.charAt(i))) {
                node.children.put(word.charAt(i), new TrieNode());
            }
            node = node.children.get(word.charAt(i));
        }

        node.last = true;
    }

    public int findRoot(String word) {
        TrieNode node = root;
        int idx = 0;

        for (int i = 0; i < word.length(); i++) {
            if (node.last) break;
            if (!node.children.containsKey(word.charAt(i))) {
                idx = word.length();
                break;
            }
            node = node.children.get(word.charAt(i));
            idx++;
        }

        return idx;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");

        for (int i = 0; i < dictionary.size(); i++) {
            trie.insert(dictionary.get(i));
        }

        for (String word: words) {
            int idx = trie.findRoot(word);
            for (int i = 0; i < idx; i++) {
                sb.append(word.charAt(i));
            }
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}