class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!sb.isEmpty() &&
                (Character.isUpperCase(sb.charAt(sb.length() - 1))
                    && Character.toLowerCase(sb.charAt(sb.length() - 1)) == s.charAt(i)
                    || (Character.isLowerCase(sb.charAt(sb.length() - 1))
                        && Character.toUpperCase(sb.charAt(sb.length() - 1)) == s.charAt(i)))) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
