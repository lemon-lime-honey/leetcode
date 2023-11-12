class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int n = 300;

        for (String str: strs) {
            n = Math.min(n, str.length());
        }

        for (int i = 0; i < n; i++) {
            char target = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != target) {
                    return sb.toString();
                }
            }
            sb.append(target);
        }

        return sb.toString();
    }
}