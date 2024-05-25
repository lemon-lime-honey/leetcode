class Trie {
    private TrieNode root;

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

    public List<Integer> find(int idx, String str) {
        List<Integer> result = new ArrayList<>();
        TrieNode node = root;

        for (int i = idx; i < str.length(); i++) {
            if (!node.children.containsKey(str.charAt(i))) return result;
            if (node.children.get(str.charAt(i)).last) result.add(i + 1);
            node = node.children.get(str.charAt(i));
        }

        return result;
    }
}

class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean last;

    public TrieNode() {
        children = new HashMap<>();
        last = false;
    }
}

class Solution {
    private List<String> result;
    private Trie trie;

    private void run(int idx, List<String> route, String s) {
        List<Integer> targets = trie.find(idx, s);

        for (int i = 0; i < targets.size(); i++) {
            route.add(s.substring(idx, targets.get(i)));
            if (targets.get(i) == s.length()) result.add(String.join(" ", route));
            else run(targets.get(i), route, s);
            route.remove(route.size() - 1);
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        trie = new Trie();
        result = new ArrayList<>();

        for (int i = 0; i < wordDict.size(); i++) {
            trie.insert(wordDict.get(i));
        }

        run(0, new ArrayList<>(), s);

        return result;
    }
}