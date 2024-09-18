class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> wordDict = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (String word: s1.split(" ")) {
            wordDict.put(word, wordDict.getOrDefault(word, 0) + 1);
        }

        for (String word: s2.split(" ")) {
            wordDict.put(word, wordDict.getOrDefault(word, 0) + 1);
        }

        for (String word: wordDict.keySet()) {
            if (wordDict.get(word) == 1) {
                res.add(word);
            }
        }

        return res.toArray(new String[res.size()]);
    }
}