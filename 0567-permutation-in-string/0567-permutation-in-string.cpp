class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        vector<int> letters(26, 0);
        int lo = 0, hi = 0, cnt = s1.length();
        int n = s1.length(), m = s2.length();

        for (int i = 0; i < n; i++) {
            letters[s1[i] - 'a']++;
        }

        while (hi < m) {
            if (letters[s2[hi] - 'a'] > 0) {
                cnt--;
            }
            letters[s2[hi] - 'a']--;
            hi++;

            if (cnt == 0) return true;

            if (hi - lo == n) {
                if (letters[s2[lo] - 'a'] >= 0) {
                    cnt++;
                }
                letters[s2[lo] - 'a']++;
                lo++;
            }
        }

        return false;
    }
};