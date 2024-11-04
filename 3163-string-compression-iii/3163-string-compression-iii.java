class Solution {
    public String compressedString(String word) {
        StringBuilder result = new StringBuilder();
        int cnt = 1;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                if (cnt == 9) {
                    result.append(cnt);
                    result.append(word.charAt(i - 1));
                    cnt = 1;
                } else {
                    cnt++;
                }
            } else {
                result.append(cnt);
                result.append(word.charAt(i - 1));
                cnt = 1;
            }
        }

        result.append(cnt);
        result.append(word.charAt(word.length() - 1));

        return result.toString();
    }
}