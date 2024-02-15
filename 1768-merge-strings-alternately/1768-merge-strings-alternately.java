class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int n = word1.length(), m = word2.length(), idx = 0;

        while (idx < n && idx < m) {
            sb.append(word1.charAt(idx));
            sb.append(word2.charAt(idx));
            idx++;
        }

        while (idx < n) {
            sb.append(word1.charAt(idx));
            idx++;
        }

        while (idx < m) {
            sb.append(word2.charAt(idx));
            idx++;
        }

        return sb.toString();
    }
}