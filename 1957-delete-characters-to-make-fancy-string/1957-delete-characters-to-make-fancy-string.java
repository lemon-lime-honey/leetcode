class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                result.append(s.charAt(i));
                cnt = 1;
            } else if (cnt == 2) {
                continue;
            } else {
                cnt++;
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}