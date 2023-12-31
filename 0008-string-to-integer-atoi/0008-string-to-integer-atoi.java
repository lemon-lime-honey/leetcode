class Solution {
    public int myAtoi(String s) {
        boolean negative = false;
        boolean start = false;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!start) {
                if (s.charAt(i) == ' ') {
                    continue;
                } else if (s.charAt(i) == '+') {
                    start = true;
                } else if (s.charAt(i) == '-') {
                    negative = true;
                    start = true;
                } else if (Character.isDigit(s.charAt(i))) {
                    result = s.charAt(i) - '0';
                    start = true;
                } else {
                    break;
                }
            } else {
                if (Character.isDigit(s.charAt(i))) {
                    int num = s.charAt(i) - '0';
                    if (result > (Integer.MAX_VALUE - num) / 10) {
                        if (negative) {
                            return Integer.MIN_VALUE;
                        } else {
                            return Integer.MAX_VALUE;
                        }
                    }
                    result = result * 10 + num;
                } else {
                    break;
                }
            }
        }

        if (negative) {
            return result * -1;
        }

        return result;
    }
}