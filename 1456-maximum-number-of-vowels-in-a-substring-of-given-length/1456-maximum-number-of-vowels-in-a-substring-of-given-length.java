class Solution {
    public int maxVowels(String s, int k) {
        int cnt = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                cnt++;
            }
        }

        int result = cnt;
        int lo = 1, hi = k;

        while (hi < s.length()) {
            if (isVowel(s.charAt(lo - 1))) {
                cnt--;
            }
            if (isVowel(s.charAt(hi))) {
                cnt++;
            }
            result = Math.max(result, cnt);
            lo++;
            hi++;
        }

        return result;
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}