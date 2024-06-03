class Solution {
    public int appendCharacters(String s, String t) {
        int idx = 0;

        for (int i = 0; i < s.length(); i++) {
            if (idx == t.length()) break;
            if (t.charAt(idx) == s.charAt(i)) idx++;
        }

        return t.length() - idx;
    }
}