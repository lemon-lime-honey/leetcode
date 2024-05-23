class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            stack.add(s.charAt(i));
            while (stack.size() > 1
                    && ((stack.get(stack.size() - 1) == 'B' && stack.get(stack.size() - 2) == 'A')
                            || (stack.get(stack.size() - 1) == 'D'
                                    && stack.get(stack.size() - 2) == 'C'))) {
                stack.pop();
                stack.pop();
            }
        }

        return stack.size();
    }
}
