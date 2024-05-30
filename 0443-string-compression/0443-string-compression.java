class Solution {
    public int compress(char[] chars) {
        int result = 0, idx = 0;

        while (idx < chars.length) {
            char target = chars[idx];
            int cnt = 0;

            while (idx < chars.length && chars[idx] == target) {
                idx++;
                cnt++;
            }

            chars[result] = target;
            result++;

            if (cnt > 1) {
                for (char c: String.valueOf(cnt).toCharArray()) {
                    chars[result] = c;
                    result++;
                }
            }
        }

        return result;
    }
}