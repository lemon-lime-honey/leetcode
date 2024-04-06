class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] str = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                stack.push(i);
            } else if (str[i] == ')') {
                if (stack.isEmpty()) {
                    str[i] = '*';
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            str[stack.pop()] = '*';
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length; i++) {
            if (str[i] != '*') {
                sb.append(str[i]);
            }
        }

        return sb.toString();
    }
}