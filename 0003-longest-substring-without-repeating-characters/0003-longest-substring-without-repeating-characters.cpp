class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        set<char> seen;
        int result = 0;
        int i = 0;
        int j = 0;

        while (j < s.length()) {
            if (!seen.contains(s[j])) {
                seen.insert(s[j]);

                result = max(result, j - i + 1);
            } else {
                while (i < j && s[i] != s[j]) {
                    seen.erase(s[i]);
                    i++;
                }
                i++;
            }
            j++;
        }

        return result;
    }
};