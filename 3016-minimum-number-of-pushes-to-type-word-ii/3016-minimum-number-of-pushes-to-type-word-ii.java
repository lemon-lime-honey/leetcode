class Solution {
    public int minimumPushes(String word) {
        int[] letters = new int[26];

        for (int i = 0; i < word.length(); i++) {
            letters[word.charAt(i) - 'a'] += 1;
        }

        Arrays.sort(letters);

        int idx = 1, cnt = 1, result = 0;

        for (int i = 25; i >= 0; i--) {
            if (letters[i] == 0) break;
            if (idx < 9) {
                idx++;
            } else {
                idx = 2;
                cnt++;
            }
            result += letters[i] * cnt;
        }

        return result;
    }
}