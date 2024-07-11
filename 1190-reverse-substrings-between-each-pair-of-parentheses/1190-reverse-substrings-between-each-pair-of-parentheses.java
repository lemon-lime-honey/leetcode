class Solution {
    public String reverseParentheses(String s) {
        Map<Integer, Integer> pair = new HashMap<>();
        Stack<Integer> temp = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                temp.push(i);
            } else if (s.charAt(i) == ')') {
                int idx = temp.pop();
                pair.put(idx, i);
                pair.put(i, idx);
            }
        }

        StringBuilder result = new StringBuilder();
        int direction = 1, idx = 0;

        while (idx < s.length()) {
            if (s.charAt(idx) == '(' || s.charAt(idx) == ')') {
                idx = pair.get(idx);
                direction *= -1;
            } else {
                result.append(s.charAt(idx));
            }
            idx += direction;
        }

        return result.toString();
    }
}