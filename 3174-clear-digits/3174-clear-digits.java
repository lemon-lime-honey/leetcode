class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                if (sb.length() != 0) sb.setLength(sb.length() - 1);
                continue;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}