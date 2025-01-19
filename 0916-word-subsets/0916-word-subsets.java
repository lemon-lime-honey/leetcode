class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] freq = new int[26];
        List<String> result = new ArrayList<>();

        for (String word: words2) {
            int[] f = new int[26];
            for (int i = 0; i < word.length(); i++) {
                f[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (freq[i] < f[i]) {
                    freq[i] = f[i];
                }
            }
        }

        for (String word: words1) {
            int[] f = new int[26];
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                f[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (f[i] < freq[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) result.add(word);
        }

        return result;
    }
}