class Solution {
public:
    int strStr(string haystack, string needle) {
        int idx = 0;
        int n = haystack.length(), m = needle.length();

        while (idx <= n - m) {
            for (int i = 0; i < m; i++) {
                if (haystack[idx + i] != needle[i]) break;
                if (i == m - 1) return idx;
            }
            idx++;
        }

        return -1;
    }
};