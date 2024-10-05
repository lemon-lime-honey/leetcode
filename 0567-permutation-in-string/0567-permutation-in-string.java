class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] letters = new int[26];
        int lo = 0, hi = 0;
        int n = s1.length(), m = s2.length();
        int cnt = n;

        for (int i = 0; i < n; i++) {
            letters[s1.charAt(i) - 'a']++;
        }

        while (hi < m) {
            if (letters[s2.charAt(hi) - 'a'] > 0) {
                cnt--;
            }
            letters[s2.charAt(hi) - 'a']--;
            hi++;

            if (cnt == 0) return true;

            if (hi - lo == n) {
                if (letters[s2.charAt(lo) - 'a'] >= 0) {
                    cnt++;
                }
                letters[s2.charAt(lo) - 'a']++;
                lo++;
            }
        }

        return false;
    }
}