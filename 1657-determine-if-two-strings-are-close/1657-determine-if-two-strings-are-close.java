class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] letter1 = new int[26];
        int[] letter2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            letter1[word1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < word2.length(); i++) {
            letter2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((letter1[i] != 0 && letter2[i] == 0) ||
                (letter1[i] == 0 && letter2[i] != 0)) {
                return false;
            }
        }

        Arrays.sort(letter1);
        Arrays.sort(letter2);

        for (int i = 25; i > -1; i--) {
            if (letter1[i] != letter2[i]) return false;
            else if (letter1[i] == 0) return true;
        }

        return true;
    }
}