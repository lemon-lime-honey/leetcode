class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> num = new Stack();
        int n = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                n = n * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder();
                int limit = num.pop();
                while (!sb.isEmpty() && sb.charAt(sb.length() - 1) != '[') {
                    temp.append(sb.charAt(sb.length() - 1));
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.deleteCharAt(sb.length() - 1);
                temp.reverse();
                for (int j = 0; j < limit; j++) {
                    sb.append(temp.toString());
                }
            } else if (s.charAt(i) == '[') {
                sb.append(s.charAt(i));
                num.add(n);
                n = 0;
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}