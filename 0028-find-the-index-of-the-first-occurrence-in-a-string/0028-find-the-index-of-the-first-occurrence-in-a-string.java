class Solution {
    public int strStr(String haystack, String needle) {
        int idx = 0;
        int n = haystack.length();
        int m = needle.length();

        while (idx <= n - m) {
            for (int i = 0; i < m; i++) {
                if (haystack.charAt(idx + i) != needle.charAt(i)) break;
                if (i == m - 1) return idx;
            }
            idx++;
        }

        return -1;
    }
}